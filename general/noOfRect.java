
/*
 * JVS Infra Pvt Ltd purchased a flatland of size M*N, and it is divided
 * into 1*1 cells. They mave marked some cells with red colors indicated
 * with 1 and other cells with blue color indicated with 0.
 * 
 * They want build the walls in the form of rectangles by connecting four
 * distinct
 * red colored cells on the flatland that forms an axis-aligned rectangle.
 * And only the corners of the walls need to be red colored.
 * 
 * Your task is to help, JVS Infra to count the number of rectangular walls
 * can be built by connecting the red colored cells on the flatland.
 * 
 * Input Format:
 * -------------
 * Line-1: Two space separated integers, M and N
 * Next M lines: N space separated integers, either 0 or 1 only.
 * 
 * Output Format:
 * --------------
 * Print an integer result.
 * 
 * 
 * Sample Input-1:
 * ---------------
 * 3 4
 * 1 0 1 0
 * 1 1 1 1
 * 0 1 1 1
 * 
 * Sample Output-1:
 * ----------------
 * 4
 * 
 * Explanation:
 * -----------
 * Given flatland is:
 * 1 0 1 0
 * 1 1 1 1
 * 0 1 1 1
 * Number of rectngular walls are: 4
 * rectangle-1: by connecting 1's at (0, 0), (1, 0), (0, 2), (1, 2)
 * rectangle-2: by connecting 1's at (1, 1), (1, 2), (2, 1), (2, 2)
 * rectangle-3: by connecting 1's at (1, 1), (1, 3), (2, 1), (2, 3)
 * rectangle-4: by connecting 1's at (1, 2), (2, 2), (1, 3), (2, 3)
 * 
 * 
 * Sample Input-2:
 * ---------------
 * 4 5
 * 1 0 1 0 1
 * 0 0 0 1 0
 * 0 1 1 0 1
 * 1 0 1 0 0
 * 
 * Sample Output-2:
 * ----------------
 * 2
 */
import java.util.*;

public class noOfRect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[i][j] == 1) {
                    count = count + check(a, i, j);
                }
            }
        }
        System.out.print(count);
    }

    static int check(int[][] a, int i, int j) {
        int c = 0;
        for (int k = j + 1; k < a[0].length; k++) {
            if (a[i][k] == 1) {
                for (int t = i + 1; t < a.length; t++) {
                    if (a[t][j] == 1 && a[t][k] == 1)
                        c++;
                }
            }
        }
        return c;
    }
}