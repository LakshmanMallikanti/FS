package Collections;

import java.util.Collections;
import java.util.PriorityQueue;

public class priorityqueue {
    public static void main(String... inputs) {
        PriorityQueue<Integer> I = new PriorityQueue<>();// store in ascending order
        // PriorityQueue<Integer> I = new
        // PriorityQueue<>(Collections.reverseOrder());//store in descending order
        PriorityQueue<Integer> D = new PriorityQueue<>(Collections.reverseOrder());
        I.add(1);
        I.add(2);
        I.add(3);
        D.add(1);
        D.add(3);
        System.out.println(I);
        System.out.println(D);
        int a = I.poll();// return and remove the first element
        I.add(10);// throws exception if it fails
        I.offer(23);// doesnt throw exceptions instead return false
        System.out.println(D.peek());
        I.remove(10);// remove 10
        System.out.println(I.peek());// return the first element without removing it
        System.out.println(I.poll());// return and remove the first element
        System.out.println(I.contains(10));
        System.out.println(I.toString());

    }
}
