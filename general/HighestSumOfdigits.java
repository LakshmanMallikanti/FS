package general;

import java.util.*;

public class HighestSumOfdigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSize = 0;

        // Compute digit sums and store counts
        for (int i = 1; i <= n; i++) {
            int digitSum = sumOfDigits(i);
            map.put(digitSum, map.getOrDefault(digitSum, 0) + 1);
            maxSize = Math.max(maxSize, map.get(digitSum));
        }

        // Count groups with maxSize
        int count = 0;
        for (int freq : map.values()) {
            if (freq == maxSize) {
                count++;
            }
        }

        System.out.println(map);
    }

    static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
