import java.util.*;

public class decrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String c = sc.next();
        int open = -1;
        int close = -1;
        String res = decryp(c, open, close, c.length());
        System.out.print(res);
    }

    public static String decryp(String s, int c, int o, int n) {

        if (c == 0 && o == n - 1) {
            StringBuilder res = new StringBuilder(s.substring(1, n - 1));
            return res.reverse().toString();
        }
        if (c > 0 && o > 0) {
            StringBuilder sub = new StringBuilder(s.substring(c + 1, o));
            s = s.substring(0, c) + sub.reverse().toString() + s.substring(o + 1, n);
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                c = i;
                o = i;
            }
            if (s.charAt(i) == ')') {
                o = i;
                break;
            }
        }
        System.out.println("s=" + s + " c=" + c + " o=" + o);
        return decryp(s, c, o, n);
    }
}