public abstract class Course {
    private String courseName;
    private Instructor[] instructorID;
    private Student[] students;

    protected Course(String courseName, Instructor instructorID, Student students){
        this.courseName=courseName;
        this.instructorID= new Instructor[]{instructorID};
        this.students= new Student[]{students};
    }
    public String getCourseName( ){
        return courseName;
    }
    public void setCourseName(String Major){
        this.courseName=Major;
    }
    public Instructor[] getInstructor( ) {
        return instructorID;
    }
    public void setInstructor(Instructor[] instructor){
        this.instructorID=instructor;
    }
    public Student []getStudents() {
        return students;
    }
    public void setStudents(Student []students){
        this.students=students;
    }

    public abstract void calculateAverage();

}
