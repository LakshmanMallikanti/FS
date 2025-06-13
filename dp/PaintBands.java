
/*

 
  
You are organizing   a gr and parade where ' N' marching bands will move in a
straight line .  Eac h  band must wear uniform s of exactly one color chosen from 'K'
available col   o rs.  T o keep the parade visually appealing and avoid monotony, you
must follow t      h   i s   i m portant g u i deline:
                        
- No more tha   n     't w   o  

    

      
           
            
           
            
         
                    
            ma t :
         
         -- -- --         
            s N and K
        
        Format:        
--------------
Print an integer, Number of ways.

Example 1:  
----------
Input: 
3 2
Output:
6  

Explanation:
------------
Bands	band-1	band-2	band-3
----- 	----- 	----- 	-----
1		c1 		c1		c2
2		c1 		c2 		c1
3		c1 		c2 		c2
4		c2 		c1 		c1
5		c2 		c1 		c2
6		c2 		c2 		c1

Example 2:  
----------
Input: 
1 1
Output: 
1


Constraints:  
- 1 <= n <= 50  
- 1 <= k <= 10^5 
- The result will always be within the range of a 32-bit signed integer.

*/import java.util.*;

public class PaintBands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of bands
        int k = sc.nextInt(); // number of colors

        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(k);
            return;
        }

        int same = 0;
        int diff = k;

        for (int i = 2; i <= n; i++) {
            int newSame = diff;
            int newDiff = (same + diff) * (k - 1);
            same = newSame;
            diff = newDiff;
        }

        System.out.println(same + diff);
    }
}
