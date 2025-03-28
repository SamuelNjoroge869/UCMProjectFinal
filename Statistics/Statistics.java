public class Statistics extends Course {
    public static final int NO_OF_UNITS = 5;
    private final double[] grade = new double[NO_OF_UNITS];
    public double average;

    public Statistics(String courseName, Instructor[] instructorID, Student[] students, double mark1, double mark2, int mark3, int mark4, int mark5) {
        super(courseName, instructorID[2], students[5]);
        grade[0] = mark1;
        grade[1] = mark2;
        grade[2] = mark3;
        grade[3] = mark4;
        grade[4] = mark5;
        setStudents(getStudents());
        setInstructor(getInstructor());
        setCourseName(getCourseName());
    }

    public void calculateAverage() {
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Input grade" + (i + 1));
            sum += grade[i];
        }
        average = sum / 5;
        if (average >= 70 && average <= 100) {
            System.out.println("A");
        } else if (average >= 40 && average < 70) {
            System.out.println("B");
        } else if (average < 40 && average >= 0) {
            System.out.println("RETAKE!!!!");
        }

    }

}
