
/*
input=[a]c[e,f]
output=[ace,acf]

*/
package backtracking;

import java.util.*;

public class PosibleStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<ArrayList<String>> str = new ArrayList<>();
        int idx = 0;
        while (idx < s.length()) {
            if (s.charAt(idx) == '[') {
                ArrayList<String> min = new ArrayList<>();
                String k = "";
                idx++;
                while (idx < s.length() && s.charAt(idx) != ']' && s.charAt(idx) != ',') {

                    k = k + s.charAt(idx);
                    idx++;
                }
                min.add(k);
                str.add(min);
                idx++;
            } else {
                String t = "";
                while (idx < s.length() && s.charAt(idx) != '[' && s.charAt(idx) != ']') {
                    if (s.charAt(idx) != ',')
                        t = t + s.charAt(idx);
                    idx++;
                }
                str.add(t);
                idx++;
            }
        }
        System.out.print(str);
        ArrayList<String> res = new ArrayList<>();
        build(0, 0, str, res, new StringBuilder());
        System.out.print(res);
    }

    static void build(int lid, int sid, ArrayList<String> str, ArrayList<String> res, StringBuilder ans) {
        if (lid == str.size() || sid == str.get(lid).length()) {
            if (ans.length() == str.size())
                res.add(ans.toString());
            return;
        }
        ans.append(str.get(lid).charAt(sid));
        build(lid + 1, sid, str, res, ans);
        ans.deleteCharAt(ans.length() - 1);
        build(lid, sid + 1, str, res, ans);
    }
}