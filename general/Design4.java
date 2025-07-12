
/*
Build a grading system for university students based on test scores and assignment completion.

Scoring:
--------
- Test Score = average of 2 test marks
- Assignment Score = min(1, assignmentsCompleted / 10)
- Final Grade = (0.6 × Test Score) + (0.4 × Assignment Score × 100)

Grade Assignment:
-----------------
- Score ≥ 90 → A
- 75 ≤ Score < 90 → B
- 60 ≤ Score < 75 → C
- < 60 → D

Tasks to Complete:
------------------
1. Create Student POJO
   - Fields: name, test1, test2, assignmentsCompleted

2. Create GradeReport POJO
   - Fields: Student, finalGrade (double), gradeLetter

3. Create interface Grader
   - Method: GradeReport generateGrade(Student student);

4. Implement in GraderImpl class.

5. Main class:
   - Create 3 sample students and print reports.
*/
import java.util.*;

class Student {
    private String name;
    private double test1;
    private double test2;
    private int assignmentsCompleted;

    public Student(String name, double test1, double test2, int assignmentsCompleted) {
        this.name = name;
        this.test1 = test1;
        this.test2 = test2;
        this.assignmentsCompleted = assignmentsCompleted;
    }

    public String getName() {
        return name;
    }

    public double getTest1() {
        return test1;
    }

    public double getTest2() {
        return test2;
    }

    public int getAssignmentsCompleted() {
        return assignmentsCompleted;
    }
}

class GradeReport {
    private Student student;
    private double finalGrade;
    private String gradeLetter;

    public GradeReport(Student student, double finalGrade, String gradeLetter) {
        this.student = student;
        this.finalGrade = finalGrade;
        this.gradeLetter = gradeLetter;
    }

    @Override
    public String toString() {
        return "Grade Report for " + student.getName() + ":\n" +
                "Final Grade: " + String.format("%.2f", finalGrade) + "\n" +
                "Letter Grade: " + gradeLetter + "\n";
    }
}

interface Grader {
    GradeReport generateGrade(Student student);
}

class GraderImpl implements Grader {
    @Override
    public GradeReport generateGrade(Student s) {
        double testAvg = (s.getTest1() + s.getTest2()) / 2.0;
        double assignmentScore = Math.min(1.0, (double) s.getAssignmentsCompleted() / 10);
        double finalGrade = (0.6 * testAvg) + (0.4 * assignmentScore * 100);

        String gradeLetter;
        if (finalGrade >= 90) {
            gradeLetter = "A";
        } else if (finalGrade >= 75) {
            gradeLetter = "B";
        } else if (finalGrade >= 60) {
            gradeLetter = "C";
        } else {
            gradeLetter = "D";
        }

        return new GradeReport(s, finalGrade, gradeLetter);
    }
}

public class Design4 {
    public static void main(String[] args) {
        Grader grader = new GraderImpl();

        // Sample Students
        Student s1 = new Student("Bablu", 88, 92, 9);
        Student s2 = new Student("Anya", 70, 78, 10);
        Student s3 = new Student("Ravi", 50, 55, 5);

        // Generate and print reports
        System.out.println(grader.generateGrade(s1));
        System.out.println(grader.generateGrade(s2));
        System.out.println(grader.generateGrade(s3));
    }
}
