package strings;

import java.util.*;

public class harmonious {

    public static void main(String... input) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.next().toCharArray();
        System.out.print(harmonious(c));
    }

    static String harmonious(char[] a) {

        int max = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Character> list = new ArrayList<>();
            for (int j = i; j < a.length; j++) {
                list.add(a[j]);
                System.out.println(list);
                System.out.println(check(list));
                if (check(list)) {
                    if (max < list.size()) {
                        res = str(list);
                        max = list.size();
                    }
                }
            }

        }
        return res.toString();
    }

    static boolean check(ArrayList<Character> a) {
        for (int i = 0; i < a.size(); i++) {
            if (!a.contains((char) (a.get(i) + 32)) && !a.contains((char) (a.get(i) - 32)))
                return false;
        }
        return true;
    }

    static StringBuilder str(ArrayList<Character> a) {
        StringBuilder k = new StringBuilder();
        for (char d : a) {
            k.append(d);
        }
        return k;
    }
}
