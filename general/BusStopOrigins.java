/*
 * Problem Title: Bus Stop Origins
 * 
 * Starting Point
 * 
 * On the way to Tracy's coaching center and her home, there are exactly N bus
 * stops. These are numbered from 1 (coaching center) to N (Tracy’s home).The
 * number of buses that can be boarded from each bus stop is also given.
 * 
 * Note:" A bus will only stop at a bus stop whose number is a multiple of the bus stop number from which the bus originates"
 * 
 * Find the number of buses originating from each bus stop between her coaching
 * center and her home.
 * 
 * Input Specification
 * -------------------
 * input1: N Total number of bus stops. N<=10⁴
 * input2: Array of N Elements, Bus[],Bus[i] = Number of buses that can be
 * boarded from (i+1)th stop ,Bus(i)<=100
 * 
 * Output Specification
 * ---------------------
 * Return an array of N elements: Result[],Result[i] = Number of buses
 * originating from the (i+1)-th stop.
 * 
 * Example 1:
 * ----------
 * input1 = 3
 * input2 = [1, 2, 3]
 * 
 * Output:
 * [1, 1, 2]
 * 
 * Explanation:
 * -----------
 * 1 bus originates from the 1st bus stop and stops at all the bus stops.Hence,
 * number of buses originating from 2nd bus stop = 2-1=1; bus from 2nd bus stop
 * will not stop at 3rd bus stop. Hence number of buses originating from the 3rd
 * bus stop =3-1( bus from 1st bus stop)=2.
 * 
 * Example 2:
 * ---------
 * input1 = 2
 * input2 = [2, 7]
 * 
 * 
 * Output:
 * [2, 5]
 * 
 * Explanation:
 * ------------
 * 2 buses originate from 1st bus stop at the second bus stop.Hence number of
 * buses originating from 1st bus stop is 7-2=5.
 * 
 * 
 */
import java.util.*;

public class BusStopOrigins {
    public static int[] findBusOrigins(int N, int[] Bus) {
        int[] origin = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            origin[i] = Bus[i];
            for (int j = 2 * (i + 1); j <= N; j += (i + 1)) {
                origin[i] -= origin[j - 1];
            }
        }
        return origin;
    }

    // For testing the function
    public static void main(String[] args) {
        int input1 = 3;
        int[] input2 = {1, 2, 3};
        int[] result = findBusOrigins(input1, input2);
        System.out.println(Arrays.toString(result));  // Output: [1, 1, 2]

        int input3 = 2;
        int[] input4 = {2, 7};
        int[] result2 = findBusOrigins(input3, input4);
        System.out.println(Arrays.toString(result2));  // Output: [2, 5]
    }
}
