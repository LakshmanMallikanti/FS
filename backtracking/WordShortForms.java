
/*
 * Now a days, everyone is used to type the words in short-forms,
 * A short-form can be created by replacing non-intersected substrings
 * and non-adjacent substrings with their respective lengths.
 * 
 * e.g., elite can be written as follows:
 * - e3e (by replacing lit with 3),
 * - el2e (by replacing it with 2),
 * - 1l1t1 (by replacing e,i,e, with 1,1,1)
 * - 3t1 (by replacing eli and e with 3 and 1), etc.
 * and can't be written as follows:
 * - 22e (by replacing el and it with 2 and 2)
 * - 32 (by replacing eli and te with 3 and 2)
 * 
 * You will be given a word.
 * Your task is to find all possible short-forms of the given word,
 * and print them as a list of lexicographic order.
 * 
 * 
 * 
 * Input Format:
 * -------------
 * A string W, the word.
 * 
 * Output Format:
 * --------------
 * Print the list of possible short-forms of W in lexographic order.
 * 
 * 
 * Sample Input-1:
 * ---------------
 * kmit
 * 
 * Sample Output-1:
 * ----------------
 * [1m1t, 1m2, 1mi1, 1mit, 2i1, 2it, 3t, 4, k1i1, k1it, k2t, k3, km1t, km2,
 * kmi1, kmit]
 * 
 * 
 * Sample Input-2:
 * ---------------
 * cse
 * 
 * Sample Output-2:
 * ----------------
 * [1s1, 1se, 2e, 3, c1e, c2, cs1, cse]
 */
import java.util.*;

/*public class WordShortForms {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        List<String> result = new ArrayList<>();
        backtrack(word, 0, "", 0, result);
        Collections.sort(result); // lexicographic order
        System.out.println(result);
    }

    static void backtrack(String word, int pos, String cur, int count, List<String> result) {
        if (pos == word.length()) {
            if (count > 0)
                cur += count;
            result.add(cur);
        } else {
            // Option 1: Abbreviate current char (increase count)
            backtrack(word, pos + 1, cur, count + 1, result);

            // Option 2: Keep current char
            String updated = cur;
            if (count > 0)
                updated += count;
            updated += word.charAt(pos);
            backtrack(word, pos + 1, updated, 0, result);
        }
    }
}
*/
public class WordShortForms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> ans = new ArrayList<>();
        bt(s, 0, "", 0, ans);
        Collections.sort(ans);
        System.out.println(ans);
    }

    public static void bt(String s, int index, String path, int count, ArrayList<String> ans) {
        if (index >= s.length()) {
            if (count > 0) {
                path = path + count;
            }
            ans.add(path);
            return;
        }
        bt(s, index + 1, path, count + 1, ans); // Abbreviate current character
        String updated = path;
        if (count > 0) {
            updated = updated + count;
        }
        updated = updated + s.charAt(index); // Keep current character
        bt(s, index + 1, updated, 0, ans); // Move to next character
    }
}