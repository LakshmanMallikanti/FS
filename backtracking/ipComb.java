package backtracking;

import java.util.*;

public class ipComb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> list = new ArrayList<>();
        backtrack(s, 0, "", 0, list);
        Collections.sort(list);
        System.out.println(list);
    }

    static void backtrack(String s, int index, String current, int dots, ArrayList<String> list) {
        if (dots > 4)
            return;

        if (dots == 4 && index == s.length()) {
            list.add(current.substring(0, current.length() - 1)); // remove last dot
            return;
        }

        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String part = s.substring(index, index + i);
            if (isValid(part)) {
                backtrack(s, index + i, current + part + ".", dots + 1, list);
            }
        }
    }

    static boolean isValid(String part) {
        if (part.length() > 1 && part.charAt(0) == '0')
            return false; // no leading zeroes
        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }
}
