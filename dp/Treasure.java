/*
 * you are a stealthy archaeologist exploring a circular ring of ancient tombs
 * located deep within a jungle. Each tomb holds a certain number of precious
 * artifacts. However, these tombs are protected by an ancient magical curse: if
 * you disturb two adjacent tombs during the same night, the entire ring
 * activates a trap that seals you in forever.
 * 
 * The tombs are arranged in a perfect circle, meaning the first tomb is
 * adjacent to the last. You must plan your artifact retrieval carefully to
 * maximize the number of artifacts collected in a single night without
 * triggering the curse.
 * 
 * Given an integer array artifacts representing the number of artifacts in each
 * tomb, return the maximum number of artifacts you can collect without
 * disturbing any two adjacent tombs on the same night.
 * 
 * Example 1:
 * Input:
 * 2 4 3
 * Output:
 * 4
 * 
 * Explanation: You cannot loot tomb 1 (artifacts = 2) and tomb 3 (artifacts =
 * 3), as they are adjacent in a circular setup.
 * 
 * Example 2:
 * Input:
 * 1 2 3 1
 * Output:
 * 4
 * 
 * Explanation: You can loot tomb 1 (1 artifact) and tomb 3 (3 artifacts)
 * without breaking the ancient rule.
 * Total = 1 + 3 = 4 artifacts.
 * 
 * Example 3:
 * Input:
 * 1 2 3
 * Output:
 * 3
 * 
 * Constraints:
 * - 1 <= artifacts.length <= 100
 * - 0 <= artifacts[i] <= 1000
 */
/*
 * import java.util.*;
 * public class test{
 * public static void main(String[] args){
 * Scanner sc=new Scanner(System.in);
 * String[] s=sc.nextLine().split(" ");
 * int[] a=new int[s.length];
 * int sum=0;
 * int index=0;
 * int n=a.length;
 * for(int i=0;i<n;i++) a[i]=Integer.parseInt(s[i]);
 * ArrayList<Integer> l=new ArrayList<>();
 * while(true){
 * int max=0;
 * for(int j=0;j<a.length;j++){
 * if(!l.contains(j)&&a[j]>max){
 * 
 * max=a[j];
 * index=j;
 * }
 * }
 * if(max==0){
 * System.out.print(sum);
 * return;
 * }
 * sum=sum+max;
 * a[index]=0;
 * 
 * l.add((index+1)%a.length);
 * 
 * l.add((index-1+n)%a.length);
 * }
 * }
 * }
 */