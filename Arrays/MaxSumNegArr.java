import java.util.*;

public class MaxSumNegArr {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int rightsum = 0;
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
            rightsum = rightsum + arr[i];
        }
        rightsum = rightsum - arr[0];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int k = check(i, arr);
            max = Math.max(k, max);
        }
        int max2 = Integer.MIN_VALUE; // other way
        int prev = 0, leftsum = 0;
        for (int i = 0; i < arr.length; i++) {
            leftsum = Math.max(0, leftsum + prev);
            rightsum = Math.max(0, rightsum - prev);
            max2 = Math.max(max2, leftsum + rightsum + arr[i] * arr[i]);
            prev = arr[i];
            System.out.print(max2);
        }
        System.out.print(max);
        System.out.print(max2);
    }

    static int check(int k, int[] arr) {
        int lm = arr[k] * arr[k];
        int rm = 0;
        int sum = lm;
        for (int i = k - 1; i >= 0; i--) {
            sum = sum + arr[i];
            lm = Math.max(sum, lm);
        }
        sum = 0;
        for (int i = k + 1; i < arr.length; i++) {
            sum = sum + arr[i];
            rm = Math.max(sum, rm);
        }
        return lm + rm;
    }
}