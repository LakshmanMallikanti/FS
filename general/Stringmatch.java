package general;

import java.util.*;

public class Stringmatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        // Process the first string (a)
        for (char c : a) {
            if (c == '$')
                s1.pop();
            else
                s1.push(c);
        }

        // Process the second string (b)
        for (char c : b) {
            if (c == '$')
                s2.pop();
            else
                s2.push(c);
        }

        // Compare the contents of the stacks
        if (s1.size() != s2.size()) {
            System.out.println("false");
            return;
        }

        while (!s1.isEmpty()) {
            if (!s1.pop().equals(s2.pop())) {
                System.out.println("false");
                return;
            }
        }

        // If the stacks are equal
        System.out.println("true");
    }
}
