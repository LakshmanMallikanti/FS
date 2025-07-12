
/*
You are designing a Performance Management System for employees in a company.
Each employee is evaluated based on their project scores and attendance.

Specifications:
---------------
- Project Score is the average of 3 project evaluations.
- Attendance Score = min(1, attendanceDays / 220)
- Final Score = (0.7 × Project Score) + (0.3 × Attendance Score × 100)

Classification:
---------------
- Score ≥ 85 → Excellent
- 70 ≤ Score < 85 → Good
- Score < 70 → Needs Improvement

Tasks to Complete:
------------------
1. Create a POJO class Employee
   - Fields: name, scores (array of 3 doubles), attendanceDays

2. Create a POJO class PerformanceReport
   - Fields: Employee, finalScore, grade
   - toString() should return formatted string.

3. Create an interface PerformanceEvaluator
   - Method: PerformanceReport evaluate(Employee e);

4. Create PerformanceEvaluatorImpl to implement the logic.

5. In the main class:
   - Read 2-3 employees and generate reports.
*/
import java.util.Scanner;

class Employee {
    private String name;
    private double[] scores; // size 3
    private int attendanceDays;

    public Employee(String name, double[] scores, int attendanceDays) {
        if (scores.length != 3)
            throw new IllegalArgumentException("Must have 3 project scores.");
        this.name = name;
        this.scores = scores;
        this.attendanceDays = attendanceDays;
    }

    public String getName() {
        return name;
    }

    public double[] getScores() {
        return scores;
    }

    public int getAttendanceDays() {
        return attendanceDays;
    }
}

class PerformanceReport {
    private Employee employee;
    private double finalScore;
    private String grade;

    public PerformanceReport(Employee employee, double finalScore, String grade) {
        this.employee = employee;
        this.finalScore = finalScore;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Performance Report for " + employee.getName() + ":\n" +
                "Final Score: " + String.format("%.2f", finalScore) + "\n" +
                "Grade: " + grade + "\n";
    }
}

interface PerformanceEvaluator {
    PerformanceReport evaluate(Employee e);
}

class PerformanceEvaluatorImpl implements PerformanceEvaluator {
    @Override
    public PerformanceReport evaluate(Employee e) {
        double[] scores = e.getScores();
        double projectScore = (scores[0] + scores[1] + scores[2]) / 3.0;
        double attendanceScore = Math.min(1.0, (double) e.getAttendanceDays() / 220);
        double finalScore = (0.7 * projectScore) + (0.3 * attendanceScore * 100);

        String grade;
        if (finalScore >= 85) {
            grade = "Excellent";
        } else if (finalScore >= 70) {
            grade = "Good";
        } else {
            grade = "Needs Improvement";
        }

        return new PerformanceReport(e, finalScore, grade);
    }
}

public class Design3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PerformanceEvaluator evaluator = new PerformanceEvaluatorImpl();

        System.out.print("Enter number of employees to evaluate: ");
        int n = sc.nextInt();
        sc.nextLine(); // eat newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            double[] scores = new double[3];
            System.out.print("Enter 3 project scores (separated by space): ");
            for (int j = 0; j < 3; j++) {
                scores[j] = sc.nextDouble();
            }

            System.out.print("Attendance Days: ");
            int attendance = sc.nextInt();
            sc.nextLine(); // eat newline

            Employee emp = new Employee(name, scores, attendance);
            PerformanceReport report = evaluator.evaluate(emp);
            System.out.println(report);
        }

        sc.close();
    }
}
