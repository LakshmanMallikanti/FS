import java.util.*;

public class MaxPrint {
    static int dp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 6) {
            System.out.print(n);
            return;
        }

        System.out.print(count(n, 1, 1, 0, 0));
    }

    static int count(int n, int index, int Ns, int prev, int Cn) {
        if (index > n)
            return 0;
        if (index == n)
            return Ns;
        int a1 = 0, a2 = 0;
        if (prev == 1) {
            a1 = Math.max(count(n, index + 1, Ns + Cn, 1, Cn), count(n, index + 1, Ns + 1, 0, 0));
        } else {
            a2 = Math.max(count(n, index + 1, Ns + 1, 0, 0), count(n, index + 3, 2 * Ns, 1, Ns));
        }
        return Math.max(a1, a2);
    }
}