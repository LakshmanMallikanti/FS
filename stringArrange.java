+/*
Ganesh has a habit of writing the words in backward order,
and writes the sentence without spaces.
 
Ganesh is given a sentence S (without spaces) and an integer C
His way of backward writing the sentence is as follows:
   - Break the sentence into 2C length words from begining to end.
   - Write the first C letters in backward direction of every 2C length word.
   - if there is a leftover word at the end of S with lenth lessthan 2C, then 
   - if length is lessthan C, write all the letters in backward direction.
   - if length is greater than or equal to C, write the first C letters
          in backward direction and keep the rest as it is.
           
 And return the sentence S after writing is completed.
 
Example of backward writing: 
Given sentence, S= "hellokmit" and C=2
Break the sentence into words: hell, okmi, t
Now apply backward writing on each word: ehll, komi, t
So, the final sentence is "ehllkomit"
 
 
Input Format:
-------------
Space separated string and integer, the word and C value
 
Output Format:
--------------
Print a string as result
 
 
Sample Input-1:
---------------
abcdefghijk 3

Sample Output-1:
----------------
cbadefihgjk
 

Sample Input-2:
---------------
appropriate 4
 
Sample Output-2:
----------------
rppaoprieta

*/
import java.util.*;
public class stringArrange{
    public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      String[] s=sc.nextLine().split(" ");
      String sent=s[0];
      int c=Integer.parseInt(s[1]);
      int n=sent.length();
      ArrayList<String> a=new ArrayList<>();
      int i=0;
      while(n>0){
          if(n/(2*c)>0){
              a.add(sent.substring(i*2*c,(i+1)*2*c));
              sent=sent.substring((i+1)*2*c);
              i++;
          }
          else{
              a.add(sent);
          }
          n=n/(2*c);
      }
      
      String result=conv(a,c);
      System.out.println(result);
    }
    static String conv(ArrayList<String> a,int c){
        if(a.size()==0) return "";
        String res="";
        for(int i=0;i<a.size();i++){
            if(a.get(i).length()>=c){
            StringBuilder s=new StringBuilder(a.get(i).substring(0,c));
            res=res+s.reverse().toString()+a.get(i).substring(c);
        }
    else{
         StringBuilder t=new StringBuilder(a.get(i));
            res=res+t.reverse().toString();
    }
        }
    return res;
    }
}
/*/*
Vihaar is working with strings. 
He is given two strings A and B, and another string T,
 where the length of A and B is same.
 
You can find the relative groups of letters from A and B,
using the following rule set:
	- Equality rule: 'p' == 'p'
 	- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
 	- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.
 	
Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.
 
For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".
 
You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.
 
Input Format:
-------------
Three space separated strings, A , B and T
 
Output Format:
--------------
Print a string, relatively smallest string of T.
 
 
Sample Input-1:
---------------
kmit ngit mgit
 
Sample Output-1:
----------------
 ggit
 
Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"
 
 
Sample Input-2:
---------------
attitude progress apriori
 
Sample Output-2:
----------------
 aaogoog
 
 Explanation: 
 ------------
 The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
 the relatively smallest string of T is "aaogoog" */
