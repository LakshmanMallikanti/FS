package slidingwindow;

/*
 * You are an architect designing a street with houses represented as a
 * 0-indexed
 * array house_heights of n integers, where each element represents the height
 * of
 * a house. Additionally, a binary array visibility_mask of length n is
 * provided,
 * where 1 indicates a house that contributes to the neighborhood's skyline, and
 * 0 indicates a house that does not.
 * 
 * For any house located at index i, you are tasked with determining the average
 * skyline height within a k-radius neighborhood centered at i. The average
 * skyline
 * height is the average of all house heights between indices i - k and i + k
 * (inclusive) that have a corresponding visibility value of 1 in the
 * visibility_mask.
 * 
 * If no houses with a visibility of 1 exist in the range, or if the range
 * extends
 * beyond the boundaries of the array, the average skyline height for that house
 * is -1.
 * 
 * Return an array skyline_avgs of length n, where skyline_avgs[i] is the
 * average
 * skyline height for the neighborhood centered at index i.
 * 
 * Input Format:
 * ---------------
 * Line-1: Two space separated integers, N, K
 * Line-2: N space separated integers, house_heights[].
 * Line-3: N space separated integers, visibility_mask[].
 * 
 * Output Format:
 * -----------------
 * An integer array, priority_sums[], of length n - k + 1
 * 
 * 
 * Sample Input-1:
 * ---------------
 * 7 2
 * 10 15 20 5 30 25 40
 * 1 0 1 1 0 1 1
 * 
 * Sample Output-2:
 * ----------------
 * [-1, -1, 11, 16, 22, -1, -1]
 * 
 * 
 * Explanation:
 * ------------
 * - For index 0, there are less than k houses in the left neighborhood,
 * so skyline_avgs[0] = -1.
 * - For index 1, there are less than k houses in the left neighborhood,
 * so skyline_avgs[1] = -1.
 * - For index 2, the neighborhood is [10, 15, 20, 5, 30]. From the
 * visibility_mask,
 * only the houses with heights [10, 20, 5] contribute to the skyline.
 * The average is (10 + 20 + 5) / 3 = 11.
 * - For index 3, the neighborhood is [15, 20, 5, 30, 25]. From the
 * visibility_mask,
 * only the houses with heights [20, 5, 25] contribute.
 * The average is (20 + 5 + 25) / 3 = 16.
 * - For index 4, the neighborhood is [20, 5, 30, 25, 40].
 * From the visibility_mask, only the houses with heights [20, 5, 25, 40]
 * contribute.
 * The average is (20 + 5 + 25 + 40) / 4 = 22.
 * - For index 5, there are less than k houses in the right neighborhood,
 * so skyline_avgs[5] = -1.
 * - For index 6, there are less than k houses in the right neighborhood,
 * so skyline_avgs[6] = -1.
 * 
 * 
 * Sample Input-2:
 * ---------------
 * 3 1
 * 50 60 70
 * 1 1 1
 * 
 * Sample Output-2:
 * ----------------
 * [-1, 60, -1]
 * 
 * Constraints:
 * ------------
 * 1. n == house_heights.length == visibility_mask.length
 * 2. 1 <= n <= 10^5
 * 3. 0 <= house_heights[i] <= 10^5
 * 4. visibility_mask[i] is either 0 or 1
 * 5. 0 <= k <= n
 */
import java.util.*;

public class SkylineAverage {
    public static int[] computeSkylineAvgs(int n, int k, int[] house_heights, int[] visibility_mask) {
        int[] result = new int[n];
        Arrays.fill(result, -1); // Default value is -1

        int visible_sum = 0, visible_count = 0;
        int left = 0; // Left boundary of the window

        for (int right = 0; right < n; right++) {
            // Add new house in window
            if (visibility_mask[right] == 1) {
                visible_sum += house_heights[right];
                visible_count++;
            }

            // Ensure window size remains (2k + 1)
            if (right - left + 1 > 2 * k + 1) {
                if (visibility_mask[left] == 1) {
                    visible_sum -= house_heights[left];
                    visible_count--;
                }
                left++; // Shrink from left
            }

            // Compute result only for fully valid windows
            if (right - left + 1 == 2 * k + 1) {
                result[right - k] = (visible_count > 0) ? (visible_sum / visible_count) : -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] house_heights = new int[n];
        int[] visibility_mask = new int[n];

        for (int i = 0; i < n; i++) {
            house_heights[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            visibility_mask[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(computeSkylineAvgs(n, k, house_heights, visibility_mask)));
    }
}
