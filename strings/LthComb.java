package strings;

import java.util.*;

public class LthComb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = { 'a', 'b', 'c' };
        int n = sc.nextInt();
        int l = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        combs("", c, n, list, 0);
        Collections.sort(list);
        // System.out.print(list);
        System.out.print(l <= list.size() ? list.get(l - 1) : -1);
    }

    public static void combs(String up, char[] c, int n, ArrayList<String> list, int pos) {
        pos = pos % 3;
        if (up.length() == n) {
            if (check(up))
                list.add(up);
            return;
        }
        if (up.length() > n)
            return;

        combs(up + c[pos], c, n, list, pos);
        combs(up + c[pos], c, n, list, pos + 1);
    }

    public static boolean check(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                return false;
        }
        return true;
    }
}