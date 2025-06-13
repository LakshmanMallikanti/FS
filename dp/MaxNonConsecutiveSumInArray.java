
/*🧠 Problem Statement:
You are given an array of integers where you cannot pick two adjacent elements. Find the maximum sum you can obtain.

📥 Input:
n = 6
arr = [2, 1, 4, 9, 3, 1]

📤 Output:
12
🧾 Explanation: Pick elements 2 + 9 + 1 = 12

🧩 Constraints:
1 <= n <= 10^5

-10^4 <= arr[i] <= 10^4
 */
import java.util.*;

public class MaxNonConsecutiveSumInArray {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr.length;

        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }

        int prev2 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            int include = arr[i] + prev2;
            int exclude = prev1;
            int current = Math.max(include, exclude);
            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(prev1);
    }
}
