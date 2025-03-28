import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.JTable;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Analytics extends JPanel {
    public Analytics() {
        setLayout(new BorderLayout());

        //Create charts and table
        JPanel chartPanel = new JPanel();
        chartPanel.setLayout(new BoxLayout(chartPanel, BoxLayout.X_AXIS));

        //Bar Chart for Students enrolled in each course
        JFreeChart barChart = createBarChart();
        ChartPanel barChartPanel = new ChartPanel(barChart);
        barChartPanel.setPreferredSize(new Dimension(500, 250));
        chartPanel.add(barChartPanel);

        //Pie Chart for grade distribution
        JFreeChart pieChart = createPieChart();
        ChartPanel pieChartPanel = new ChartPanel(pieChart);
        chartPanel.add(pieChartPanel);

        //Table for average grades per course
        JTable averageGradeTable = createAverageGradeTable();
        JScrollPane averageGradeScrollPane = new JScrollPane(averageGradeTable);
        chartPanel.add(averageGradeScrollPane);

        //Table for courses with students and their marks
        JTable studentMarksTable=createStudentMarksTable();
        JScrollPane marksScrollPane = new JScrollPane(studentMarksTable);
        marksScrollPane.setPreferredSize(new Dimension(200,250));

        JPanel tablePanel=new JPanel(new BorderLayout());
        tablePanel.add(marksScrollPane, BorderLayout.CENTER);

        JPanel mainPanel=new JPanel(new BorderLayout());
        mainPanel.add(chartPanel, BorderLayout.CENTER);
        mainPanel.add(tablePanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    private static JFreeChart createBarChart(){
        DefaultCategoryDataset dataset= new DefaultCategoryDataset();

        try(Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/UCM_Project","postgres","S1lv3rsn1p3r#");
            Statement statement = connection.createStatement();
            ResultSet resultSet= statement.executeQuery(" SELECT c.course_name, COUNT(*) AS Student_count FROM enrollments e JOIN courses c ON e.course_id=c.course_id  GROUP BY c.course_name")){

            while (resultSet.next()){
                String courseName= resultSet.getString("course_name");
                int studentCount= resultSet.getInt("Student_count");
                dataset.addValue(studentCount, "Students", courseName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ChartFactory.createBarChart(
                "Number of Students Enrolled per Course",
                "Course",
                "Number of Students",
                dataset);
    }
    private static JFreeChart createPieChart(){
        DefaultPieDataset dataset =new DefaultPieDataset();

        try (Connection connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/UCM_Project","postgres","S1lv3rsn1p3r#");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT grade, count(*) AS grade_count FROM enrollments GROUP BY grade")) {

            while (resultSet.next()) {
                String grade = resultSet.getString("grade");
                int count = resultSet.getInt("grade_count");
                dataset.setValue(grade, count);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ChartFactory.createPieChart(
                "Grade Distribution",
                dataset,
                true,
                true,
                false  );
    }
    private static JTable createAverageGradeTable(){
        String []studentNames= {"Course Name","Average Grade"};
        Object[][]data={};

        try(Connection connection =DriverManager.getConnection ("jdbc:postgresql://localhost:5432/UCM_Project", "postgres","S1lv3rsn1p3r#");
            Statement statement=connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT c.course_name, AVG(e.marks::numeric) AS average_grade FROM enrollments e JOIN courses c ON e.course_id=c.course_id GROUP BY c.course_name");

            List<Object[]> rowDataList=new ArrayList<>();

            while (resultSet.next()){
                String courseName= resultSet.getString("Course_name");
                double averageGrade= resultSet.getDouble("average_grade");
                Object[] row={courseName,averageGrade};
                rowDataList.add(row);
            }

            data = rowDataList.toArray(new Object [0][]);//Convert List to arrays

        }catch (SQLException e){
            e.printStackTrace();
        }
        return new JTable(data , studentNames);
    }
    public static JTable createStudentMarksTable(){
        String [] columnNames={"studentID","studentName","courseName","marks"};
        Object [][]data={};

        try(Connection connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/UCM_Project","postgres","S1lv3rsn1p3r#");
            Statement statement=connection.createStatement()){
            ResultSet resultSet=statement.executeQuery("SELECT s.student_id, s.student_name,c.course_name,e.marks FROM enrollments e JOIN students s ON e.student_id=s.student_id JOIN courses c ON e.course_id=c.course_id ORDER BY c.course_name, s.student_name");

            List<Object[]> rowDataList= new ArrayList<>();

            while(resultSet.next()){
                String studentId=resultSet.getString("student_id");
                String studentName=resultSet.getString("student_name");
                String courseName=resultSet.getString("course_name");
                int marks=resultSet.getInt("marks");
                Object []row={studentId,studentName,courseName,marks};
                rowDataList.add(row);
            }
            data=rowDataList.toArray(new Object [0][]);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new JTable(data, columnNames);
    }
    public static void main(String[]args){
        SwingUtilities.invokeLater(() ->{
                JFrame frame=new JFrame ("Student Analytics");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setContentPane(new Analytics());
                frame.setSize(1100,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);}
            );
        }
    }

