package strings;

import java.util.*;

public class Allsubstrings {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> list = new ArrayList<>();
        System.out.print(ps("", s, list));
    }

    static ArrayList<String> ps(String a, String b, ArrayList<String> list) {
        if (b.isEmpty()) {
            list.add(a);
            return list;
        }
        char ch = b.charAt(0);
        ps(a + ch, b.substring(1), list);
        ps(a, b.substring(1), list);
        return list;
    }
}
