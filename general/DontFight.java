
/*Problem Statement:

Mr. Cumberbatch is the Godfather of the town. People of different gangs have started fighting each other. Being the Godfather, he wants to keep the violence to a minimum. Since everyone respects him, the gangs stop fighting.

Now, he has to move people from that place to somewhere else.He knows the total number of people i.e X.He has a vehicle in which Y people can sit at a time.

He has made a hate mantrix which has N pairs (m,n),(1<=m,=x and 1<=n<=X) each pair means that perso m hates n, and they can travel together but will start fighting if they are left together at one place.Mr Cumberbatch has to find out the many minimum number of trips his vehicle will have to make to transport all the people without any fights.

Input Specification:
--------------------
* input1: X → Total number of people
* input2: N → Number of pairs in the hate matrix
* input3: Y → Number of people that can sit in the vehicle at a time
* input4: hate matrix  Consisting N pairs 

Output Specification:
----------------------
* Your function should return the number of trips the vehicle has to make.

Example 1:
----------
input1: 3  
input2: 2  
input3: 1  
input4: {(1,2), (2,3)}

Output:
7

Explanation:
------------
* Trip 1: person 2 to safe place
* Trip 2: vehicle back with no person
* Trip 3: person 1 to the safe place
* Trip 4: person 2 back to the original place
* Trip 5: person 3 to the safe place
* Trip 6: vehicle back with no person
* Trip 7: person 2 to the safe place



Example 2:
----------
input1: 3  
input2: 3  
input3: 2  
input4: {(1,2), (1,3), (2,3)}


Output:
3


Explanation:
------------
The trips taken will be
* Trip 1: person 1 and 2 to safe place
* Trip 2: Back with person 2 
* Trip 3: person 2 and 3 to safe place
 */
import java.util.*;

public class DontFight {
    static int minTrips = Integer.MAX_VALUE;

    public static int minTripsToTransportAll(int X, int N, int Y, int[][] hateMatrix) {
        // Step 1: Build hate graph
        Map<Integer, Set<Integer>> hateMap = new HashMap<>();
        for (int i = 1; i <= X; i++)
            hateMap.put(i, new HashSet<>());

        for (int[] pair : hateMatrix) {
            hateMap.get(pair[0]).add(pair[1]);
            hateMap.get(pair[1]).add(pair[0]);
        }

        // All people are initially at origin
        Set<Integer> origin = new HashSet<>();
        for (int i = 1; i <= X; i++)
            origin.add(i);
        Set<Integer> destination = new HashSet<>();

        dfs(origin, destination, Y, hateMap, 0, true); // true means trip from origin to destination

        return minTrips;
    }

    private static void dfs(Set<Integer> origin, Set<Integer> dest, int capacity, Map<Integer, Set<Integer>> hateMap,
            int trips, boolean forward) {
        if (origin.isEmpty()) {
            minTrips = Math.min(minTrips, trips);
            return;
        }

        // Prune inefficient paths
        if (trips >= minTrips)
            return;

        Set<Integer> current = forward ? origin : dest;
        Set<Integer> other = forward ? dest : origin;

        // Try all valid combinations of people to move
        List<Integer> currentList = new ArrayList<>(current);
        int n = currentList.size();

        for (int mask = 1; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) > capacity)
                continue;

            Set<Integer> toMove = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    toMove.add(currentList.get(i));
                }
            }

            // Validate: toMove must not hate each other
            if (!isValidGroup(toMove, hateMap))
                continue;

            // Validate: people left behind must not hate each other
            Set<Integer> leftBehind = new HashSet<>(current);
            leftBehind.removeAll(toMove);
            if (!isValidGroup(leftBehind, hateMap))
                continue;

            // Make move
            Set<Integer> newCurrent = new HashSet<>(current);
            Set<Integer> newOther = new HashSet<>(other);
            newCurrent.removeAll(toMove);
            newOther.addAll(toMove);

            dfs(newCurrent, newOther, capacity, hateMap, trips + 1, !forward); // Switch direction
        }
    }

    private static boolean isValidGroup(Set<Integer> group, Map<Integer, Set<Integer>> hateMap) {
        for (int a : group) {
            for (int b : group) {
                if (a != b && hateMap.get(a).contains(b)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Example usage
    public static void main(String[] args) {
        int X = 3;
        int N = 2;
        int Y = 1;
        int[][] hateMatrix = { { 1, 2 }, { 2, 3 } };

        System.out.println("Minimum trips: " + minTripsToTransportAll(X, N, Y, hateMatrix)); // Output: 7

        int[][] hateMatrix2 = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        System.out.println("Minimum trips: " + minTripsToTransportAll(3, 3, 2, hateMatrix2)); // Output: 3
    }
}
