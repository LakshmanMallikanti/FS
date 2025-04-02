/*
 * 
 * 
 *  Custom Comparator for Descending Order
 * 
 */

package Collections;

import java.util.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s2.marks - s1.marks; // Descending order
    }
}

public class priorityqueue3 {
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparator());
        pq.add(new Student("Alice", 85));
        pq.add(new Student("Bob", 92));
        pq.add(new Student("Charlie", 78));

        while (!pq.isEmpty()) {
            Student s = pq.poll();
            System.out.println(s.name + " - " + s.marks);
        }
        // Output:
        // Bob - 92
        // Alice - 85
        // Charlie - 78
    }
}
