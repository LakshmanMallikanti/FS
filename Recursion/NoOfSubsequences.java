package Recursion;

import java.util.*;

public class NoOfSubsequences {
    static int count = 0;

    public static void main(String[] args) {
        String s = "apple";
        process(s, 0, "");
        System.out.print(count);
    }

    static void process(String s, int index, String pro) {
        if (index == s.length()) {
            count++;
            return;
        }
        process(s, index + 1, pro); // exclude current character
        process(s, index + 1, pro + s.charAt(index)); // include current character
    }
}
