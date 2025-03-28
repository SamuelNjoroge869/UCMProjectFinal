public class Student extends Person{
    private int studentID;
    private String studentCourse;

    public Student(){}

    public Student(String Name, String Email, int age,int studentID, String studentCourse) {
        super(Name, Email, age);
        this.studentID=studentID;
        this.studentCourse=studentCourse;
        setName(Name);
        setEmail(Email);
        setAge(age);
    }

    public int getStudentID(){
        return studentID;
    }
    public void setStudentID(int myID){
        this.studentID=myID;
    }
    public String getStudentCourse(){
        return studentCourse;
    }
    public void setStudentCourse(String course){
        this.studentCourse=course;
    }

    public void displayDetails(){
        setStudentID(studentID);
        setStudentCourse(studentCourse);
        System.out.println("Student name:" +getName()+"\nStudent ID:" +getStudentID()+ "\nStudent Email: " +getEmail());
        System.out.println("Age: " +getAge());
        System.out.println("Course: " +getStudentCourse());
    }

}

