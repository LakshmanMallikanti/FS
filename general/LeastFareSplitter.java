import java.util.*;

public class LeastFareSplitter {
    public static int minFare(int[][] fares) {
        int n = fares.length;

        // Sort people based on the difference in cost between Delhi and Mumbai
        Arrays.sort(fares, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int totalCost = 0;

        // First half goes to Delhi
        for (int i = 0; i < n / 2; i++) {
            totalCost += fares[i][0];
        }

        // Second half goes to Mumbai
        for (int i = n / 2; i < n; i++) {
            totalCost += fares[i][1];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[][] fares = {
                { 1, 2 },
                { 4, 2 },
                { 3, 6 },
                { 6, 1 }
        };
        System.out.println("Least total fare: " + minFare(fares)); // Output: 7
    }
}
