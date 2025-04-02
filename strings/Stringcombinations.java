package strings;

import java.util.*;

public class Stringcombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> a = new ArrayList<>();
        p("", s, a);
        System.out.print(a);
    }

    static void p(String a, String b, ArrayList<String> list) {

        if (b.isEmpty()) {
            list.add(a);
            return;
        }
        char ch = b.charAt(0);
        for (int i = 0; i <= a.length(); i++) {
            p(a.substring(0, i) + ch + a.substring(i), b.substring(1), list);
        }
    }

}
