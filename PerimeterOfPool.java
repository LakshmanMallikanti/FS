
/*import java.util.*;

public class SquareFormation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> a = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
            sum = sum + a.get(i);
        }
        Collections.sort(a);
        if (sum % 4 != 0) {
            System.out.print(false);
            return;
        }
        int k = sum / 4;
        for (int i = 0; i < 4; i++) {
            if (!remaining(a, a.size() - 1, 0, k)) {
                System.out.print(false);
                return;
            }
            System.out.println(a);
        }
        System.out.print(true);

    }

    static boolean remaining(ArrayList<Integer> a, int i, int sum, int k) {
        if (sum == k)
            return true;
        if (i < 0 || a.size() == 0)
            return false;
        sum = sum + a.get(i);
        // System.out.println(sum);
        int t = a.get(i);
        if (t > k)
            return false;
        a.remove(i);
        boolean a1 = remaining(a, i - 1, sum, k);
        if (a1)
            return true;
        a.add(t);
        Collections.sort(a);
        sum = sum - t;
        boolean a2 = remaining(a, i - 1, sum, k);
        return a2;
    }
}*/
import java.util.*;

public class PerimeterOfPool {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] a=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) a[i][j]=sc.nextInt();
        }
        int res=0;
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(a[i][j]==1) res=Math.max(res,per(a,i,j,1));
            }
        }
        System.out.print(res);
    }

    static int per(int[][] a,int i,int j,int res){
        
        res++;
        if(j+1<n && a[i][j+1]==1) return per(a,i,j+1,res);
        res++;
        if(i+1<m && a[i+1][j]==1) return per(a,i+1,j,res);
        res++;
        if(j-1>0&& a[i][j-1]==1) return per(a,i,j-1,res);
        res++;
        if(i-1>0 && a[i-1][j]==1) return per(a,i-1,j,res);
        return 4;
        
    }
    
}