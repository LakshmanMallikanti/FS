package strings;

import java.util.*;

public class swap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        if (s[0].length() != s[1].length() || s[0].length() == 0) {
            System.out.print(false);
            return;
        }

        int c = 0;
        StringBuilder s1 = new StringBuilder(s[0]);
        StringBuilder s2 = new StringBuilder(s[1]);
        for (int i = 0; i < s[0].length(); i++) {
            if (c > 2)
                break;
            if (s[0].charAt(i) != s[1].charAt(i)) {
                c++;
            } else {
                s1.deleteCharAt(i);
                s2.deleteCharAt(i);
            }
        }

        System.out.print(s1.toString().equals(s2.reverse().toString()) && c == 2);
    }
}