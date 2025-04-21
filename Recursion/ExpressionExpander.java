package Recursion;

import java.util.*;

public class ExpressionExpander {

    static void answer(List<List<String>> groups, List<String> result, String res, int n) {
        if (res.length() == groups.size()) {
            result.add(res);
            return;
        }
        if (n == groups.size())
            return;
        for (String ch : groups.get(n)) {
            answer(groups, result, res + ch, n + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<List<String>> groups = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                i++;
                List<String> group = new ArrayList<>();
                StringBuilder temp = new StringBuilder();
                while (s.charAt(i) != ']') {
                    if (s.charAt(i) == ',') {
                        group.add(temp.toString());
                        temp.setLength(0);
                    } else {
                        temp.append(s.charAt(i));
                    }
                    i++;
                }
                group.add(temp.toString());
                Collections.sort(group);
                groups.add(group);
                i++; // skip ']'
            } else {
                groups.add(Arrays.asList(String.valueOf(s.charAt(i))));
                i++;
            }
        }

        List<String> result = new ArrayList<>();
        answer(groups, result, "", 0);
        System.out.println(result);
    }
}
