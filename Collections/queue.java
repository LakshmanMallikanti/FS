package Collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String... inputs) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(10);
        q.offer(101);
        q.offer(102);
        q.offer(103);
        q.offer(105);

        q.add(11);
        q.poll();// retrun and remove front element
        q.remove();// remove front element
        q.peek();// return first element
    }
}
