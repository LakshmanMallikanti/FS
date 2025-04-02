package Collections;

import java.util.*;

public class stack {
    public static void main(String... inputs) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s);
        System.out.println(s.pop()); // Output: 30
        System.out.println(s);
        System.out.println(s.peek()); // Output: 20
        System.out.println(s);
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.size());
        System.out.println(s);
        System.out.println(s.search(10)); // Output: 3 (from the top)
        System.out.println(s.search(50)); // Output: -1 (not found)

        Stack<String> stack = new Stack<>();

        // Push elements
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");

        // Peek top element
        System.out.println("Top element: " + stack.peek()); // Output: Cherry

        // Pop element
        System.out.println("Popped: " + stack.pop()); // Output: Cherry

        // Stack after pop
        System.out.println("Stack after pop: " + stack); // Output: [Apple, Banana]

        // Check size
        System.out.println("Size: " + stack.size()); // Output: 2

        // Check if stack contains an element
        System.out.println("Contains Banana? " + stack.search("Banana")); // Output: 1

        // Clear stack
        stack.clear();
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true

    }
}
