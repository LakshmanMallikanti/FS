
/*Given n activities with their start and finish times given in array start[] and finish[]. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time. 

Note: Duration of the activity includes both starting and finishing time.

Examples:  

Input: start[]  =  [1, 3, 0, 5, 8, 5], finish[] =  [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: A person can perform at most four activities. The maximum set of activities that can be executed is {0, 1, 3, 4} (These are indexes in start[] and finish[])


Input: start[]  =  [10, 12, 20], finish[] =  [20, 25, 30]
Output: 1
Explanation: A person can perform at most one activity.

 */
package greedy;

import java.util.*;

public class ActivitySelection {

    public static int maxActivities(int[] start, int[] finish) {
        int n = start.length;
        Integer[] indices = new Integer[n];

        // Fill the index array
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on finish times
        Arrays.sort(indices, (i, j) -> Integer.compare(finish[i], finish[j]));// ascending order
        // Arrays.sort(indices, (i, j) -> Integer.compare(finish[j],
        // finish[i]));//descending order
        int count = 1;
        int lastFinishTime = finish[indices[0]];

        for (int i = 1; i < n; i++) {
            if (start[indices[i]] >= lastFinishTime) {
                count++;
                lastFinishTime = finish[indices[i]];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] start1 = { 1, 3, 0, 5, 8, 5 };
        int[] finish1 = { 2, 4, 6, 7, 9, 9 };
        System.out.println("Maximum number of activities: " + maxActivities(start1, finish1));

        int[] start2 = { 10, 12, 20 };
        int[] finish2 = { 20, 25, 30 };
        System.out.println("Maximum number of activities: " + maxActivities(start2, finish2));

        int[] start3 = { 1, 3, 2, 5 };
        int[] finish3 = { 2, 4, 3, 6 };
        System.out.println("Maximum number of activities: " + maxActivities(start3, finish3));
    }
}
/*
 * import java.util.Arrays;
 * 
 * class GfG {
 * 
 * // Function to solve the activity selection problem
 * static int activitySelection(int[] start, int[] finish)
 * {
 * int n = start.length;
 * int ans = 0;
 * 
 * // Store activities as (finish, start) pairs
 * int[][] arr = new int[n][2];
 * for (int i = 0; i < n; i++) {
 * arr[i][0] = finish[i];
 * arr[i][1] = start[i];
 * }
 * 
 * // Sort activities based on finish time
 * Arrays.sort(arr,
 * (a, b) -> Integer.compare(a[0], b[0]));
 * 
 * // To store the end time of last activity
 * int finishtime = -1;
 * 
 * for (int i = 0; i < n; i++) {
 * if (arr[i][1] > finishtime) {
 * finishtime = arr[i][0];
 * ans++;
 * }
 * }
 * return ans;
 * }
 * 
 * public static void main(String[] args)
 * {
 * int[] start = { 1, 3, 0, 5, 8, 5 };
 * int[] finish = { 2, 4, 6, 7, 9, 9 };
 * 
 * System.out.println(
 * activitySelection(start, finish));
 * }
 * }
 */