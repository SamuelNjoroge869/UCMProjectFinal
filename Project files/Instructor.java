public class Instructor extends Person{
    private int instructorID;
    private String Department;

    public Instructor(){}

    public Instructor(String Name, String Email, int age, int InstructorID, String Department){
        super(Name, Email, age);
        this.instructorID=InstructorID;
        this.Department=Department;
        setName(Name);
        setEmail(Email);
        setAge(age);
    }
    public int getInstructorID(){
        return instructorID;
    }
    public void setInstructorID(int myID){
        this.instructorID=myID;
    }
    public String getDepartment(){
        return Department;
    }
    public void setDepartment(String myDepartment){
        this.Department=myDepartment;
    }
    public void displayDetails(){
        setInstructorID(instructorID);
        setDepartment(Department);
        System.out.println("Instructor name:" +getName()+ "\nInstructor ID:" +getInstructorID()+ "\nInstructor Email:" +getEmail());
        System.out.println("Age:" +getAge());
        System.out.println("Department:" +getDepartment());
    }

}

