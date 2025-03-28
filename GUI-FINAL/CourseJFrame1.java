import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CourseJFrame1 extends javax.swing.JFrame {


    public CourseJFrame1() {
        initComponents();
        Connect();
        CourseData();
    }

    Connection con;
    PreparedStatement pst;

    public void Connect(){

        try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost/UCM_Project","postgres","S1lv3rsn1p3r#");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CourseJFrame1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CourseJFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void CourseData(){

        try {
            int QQ;
            pst =con.prepareStatement("SELECT * FROM courses");
            ResultSet Rs =pst.executeQuery();
            ResultSetMetaData RSMD =Rs.getMetaData();
            QQ = RSMD.getColumnCount();
            DefaultTableModel DFG=(DefaultTableModel)table1.getModel();
            DFG.setRowCount(0);

            while(Rs.next()){
                Vector <Object>rowData=new Vector<>();
                rowData.add(Rs.getInt("course_id"));
                rowData.add(Rs.getString("course_name"));
                rowData.add(Rs.getInt("credits"));
                rowData.add(Rs.getString("instructor"));
                DFG.addRow(rowData);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CourseJFrame1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error retrieving course data!!: "+ex.getMessage());
        }
    }
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCId = new javax.swing.JTextField();
        txtCName = new javax.swing.JTextField();
        txtCredits = new javax.swing.JTextField();
        txtInstructor = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jLabel5.setText("Gender");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 240, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18)); // NOI18N
        jLabel1.setText("Courses");

        jButton1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jButton1))
                                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14));
        jLabel2.setText("CourseId");

        jLabel6.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24));
        jLabel6.setText("      INSERT PICTURE");
        jLabel6.setMaximumSize(new java.awt.Dimension(736, 736));
        jLabel6.setMinimumSize(new java.awt.Dimension(736, 736));
        jLabel6.setPreferredSize(new java.awt.Dimension(736, 736));

        jLabel3.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jLabel3.setText("CourseName");

        jLabel4.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jLabel4.setText("Credits");

        jLabel7.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jLabel7.setText("Instructor");

        btnInsert.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "CourseId", "Course Name", "Credits", "Instructor"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtCName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtCId, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnInsert)
                                .addGap(32, 32, 32)
                                .addComponent(btnUpdate)
                                .addGap(37, 37, 37)
                                .addComponent(btnDelete)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(txtCId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txtCName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(txtInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnInsert)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnDelete))
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(null);
    }

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try{
            int course_id=Integer.parseInt(txtCId.getText());
            String course_name=txtCName.getText();
            int credits=Integer.parseInt(txtCredits.getText());
            String instructor=txtInstructor.getText();


            pst=con.prepareStatement("INSERT INTO courses(course_id,course_name,credits,instructor)VALUES(?,?,?,?)");
            pst.setInt(1,course_id);
            pst.setString(2,course_name);
            pst.setInt(3,credits);
            pst.setString(4,instructor);

            int rowsInserted=pst.executeUpdate();
            if (rowsInserted==1) {
                JOptionPane.showMessageDialog(this, "Data Inserted Successfully ");
                txtCId.setText("");
                txtCName.setText("");
                txtCredits.setText("");
                txtInstructor.setText("");
                CourseData();
            }else{
                JOptionPane.showMessageDialog(this, "Data insertion failed!!");
            }
        }catch (SQLException ex) {
            Logger.getLogger(CourseJFrame1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Error inserting record:"+ex.getMessage());
        }

    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            DefaultTableModel model1=(DefaultTableModel) table1.getModel();
            int selectIndex=table1.getSelectedRow();
            if (selectIndex==-1){
                JOptionPane.showMessageDialog(this,"Please select the row to update. ");
                return;
            }
            int course_id= Integer.parseInt(model1.getValueAt(selectIndex,0).toString());
            String course_name=txtCName.getText();
            int credits=Integer.parseInt(txtCredits.getText());
            String instructor=txtInstructor.getText();

            pst = con.prepareStatement("UPDATE courses SET course_id= ?,course_name= ?,credits= ?,instructor= ? WHERE course_id=?");

            pst.setInt(1,course_id);
            pst.setString(2,course_name);
            pst.setInt(3,credits);
            pst.setString(4,instructor);


            int rowsUpdated=pst.executeUpdate();
            if(rowsUpdated==1) {
                JOptionPane.showMessageDialog(this, "Data Updated Successfully");
                CourseData();
            }else{
                JOptionPane.showMessageDialog(this, "Data Update failed!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseJFrame1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error updating data!!: "+ex.getMessage());
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            DefaultTableModel model1=(DefaultTableModel) table1.getModel();
            int selectIndex=table1.getSelectedRow();
            if (selectIndex==-1){
                JOptionPane.showMessageDialog(this, "Please select a row to delete.");
                return;
            }
            int course_id = Integer.parseInt(model1.getValueAt(selectIndex, 0).toString());
            pst=con.prepareStatement("DELETE FROM courses WHERE course_id=?");
            pst.setInt(1,course_id);

            int rowsDeleted=pst.executeUpdate();
            if (rowsDeleted==1) {
                JOptionPane.showMessageDialog(this, "Data Deleted Successfully");
                CourseData();
            }else{
                JOptionPane.showMessageDialog(this,"Data deletion failed!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseJFrame1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error deleting data!!: "+ex.getMessage());
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseJFrame1().setVisible(true);
            }
        });
    }


    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable table1;
    private javax.swing.JTextField txtCId;
    private javax.swing.JTextField txtCName;
    private javax.swing.JTextField txtCredits;
    private javax.swing.JTextField txtInstructor;
    // End of variables declaration//GEN-END:variables


}
