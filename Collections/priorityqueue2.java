
/*
 * To use objects in a PriorityQueue, we need to define a sorting order using Comparable or Comparator.
Example: PriorityQueue with a Custom Class
 * 
 */

package Collections;

import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Sort by marks (Ascending Order)
    public int compareTo(Student s) {
        return this.marks - s.marks;
    }
}

public class priorityqueue2 {
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Alice", 85));
        pq.add(new Student("Bob", 92));
        pq.add(new Student("Charlie", 78));

        while (!pq.isEmpty()) {
            Student s = pq.poll();
            System.out.println(s.name + " - " + s.marks);
        }
        // Output:
        // Charlie - 78
        // Alice - 85
        // Bob - 92
    }
}
