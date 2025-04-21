//LC 17. Letter Combinations of a Phone Number
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class mobileDigits {

    static final Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public static void main(String[] args) {
        mobileDigits obj = new mobileDigits();
        String digits = "23";
        List<String> combinations = obj.letterCombinations(digits);
        System.out.println(combinations); // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty())
            return res;

        comb(digits, 0, new StringBuilder(), res);
        return res;
    }

    private static void comb(String digits, int i, StringBuilder s, List<String> res) {
        if (i == digits.length()) {

            res.add(s.toString());
            return;
        }
        char c = digits.charAt(i);

        for (char ch : map.get(c).toCharArray()) {
            s.append(ch);
            comb(digits, i + 1, s, res);
            s.deleteCharAt(s.length() - 1);
        }

    }
    /*
     * or.....
     * 
     * public List<String> letterCombinations(String digits) {
     * if (digits.isEmpty()) return new ArrayList<>(); // fix for edge case
     * 
     * String[] a = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
     * "wxyz"};
     * return comb("", digits, a);
     * }
     * 
     * private static List<String> comb(String pro, String unpro, String[] a) {
     * if (unpro.isEmpty()) {
     * List<String> res = new ArrayList<>();
     * res.add(pro);
     * return res;
     * }
     * 
     * int c = unpro.charAt(0) - '0';
     * List<String> ans = new ArrayList<>();
     * for (int i = 0; i < a[c].length(); i++) {
     * char ch = a[c].charAt(i);
     * ans.addAll(comb(pro + ch, unpro.substring(1), a));
     * }
     * return ans;
     * }
     */
}
