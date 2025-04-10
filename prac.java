
/*import java.util.*;

public class prac {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        char[] c = t.toCharArray();
        String[] s = sc.nextLine().split(" ");
        int res = 0;
        for (String k : s) {
            if (check(c, k.toCharArray()))
                res++;
        }
        System.out.print(res);
    }

    static boolean check(char[] a, char[] b) {

        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        s1.append(a[0]);
        s2.append(b[0]);
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] != a[i])
                s1.append(a[i]);
        }
        for (int i = 1; i < b.length; i++) {
            if (b[i - 1] != b[i])
                s2.append(b[i]);
        }
        if (!s1.toString().equals(s2.toString()))
            return false;

        for (char k : a) {
            m1.put(k, m1.getOrDefault(k, 0) + 1);
        }
        for (char k : b) {
            m2.put(k, m2.getOrDefault(k, 0) + 1);
        }
        if (m1.size() != m2.size())
            return false;
        for (char k : a) {
            if (m1.get(k) < m2.get(k))
                return false;
        }
        return true;
    }

}*/
import java.util.*;

public class prac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i][1] <= a[i + 1][0])
                n--;
        }
        System.out.print(n == 1 || n == 0);
    }
}