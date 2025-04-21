
/*
 * import java.util.*;
 * 
 * public class test {
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in);
 * String[] s = sc.nextLine().split(" ");
 * if (s[1].length() % s[0].length() != 0 && s[0].length() % s[1].length() != 0)
 * {
 * System.out.print(false);
 * return;
 * }
 * if (s[0].length() > s[1].length()) {
 * String temp = s[0];
 * s[0] = s[1];
 * s[1] = temp;
 * }
 * int k = s[1].length() / s[0].length();
 * Map<Character, String> map = new HashMap<>();
 * for (int i = 0; i < s[0].length(); i++) {
 * map.put(s[0].charAt(i), " ");
 * }
 * 
 * for (int i = 0; i < s[0].length(); i++) {
 * if (!map.get(s[0].charAt(i)).equals(" ")
 * && !map.get(s[0].charAt(i)).equals(s[1].substring(i * k, i * k + k))) {
 * 
 * System.out.print(false);
 * return;
 * }
 * 
 * map.put(s[0].charAt(i), s[1].substring(i * k, i * k + k));
 * }
 * 
 * System.out.print(map);
 * }
 * }
 */
import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split("B");
        if (s.length == 0) {
            System.out.println(false);
            return;
        }
        if (s.length > 1) {
            int count = 0;
            for (int i = 0; i < s.length; i++) {
                if (s[i].length() > 3)
                    count++;
                if (count == 2) {
                    System.out.println(true);
                    return;
                }
            }
            System.out.println(false);
            return;
        } else {
            if (s[0].length() < 2 || s[0].length() == 5) {
                System.out.println(false);
                return;
            }

        }
        System.out.print(true);

    }

}