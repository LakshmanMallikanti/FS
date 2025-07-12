
/*import java.util.*;
public class SwapTheCandles{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] p=new int[n];
        int[] q=new int[n];
        for(int i=0;i<n;i++){
            p[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            q[i]=sc.nextInt();
        }
        int res=0,k=1,pos=0;
        while(k<n){
            if(p[k]<p[k-1]){
                while(pos<n){
                    if(q[pos]>p[k-1]){
                        int temp=p[k];
                        res++;
                        p[k]=q[pos];
                        q[pos]=temp;
                    }
                    pos++;
                }
            }
            k++;
        }
        System.out.print(res);
    }
}

*/
import java.util.*;

public class SwapTheCandles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (p[i] > p[i + 1]) {
                if (i > 0) {
                    if (p[i] < q[i]) {
                        for (int t = i - 1; t >= 0; t++) {
                            if (p[i] > q[t]) {
                                int temp = p[i];
                                p[i] = q[t + 1];
                                q[t + 1] = temp;
                                res++;
                            }
                        }
                    }
                } else {
                    for (int t = i; t < n - 1; t++) {
                        if (q[t] <= p[i + 1]) {
                            int temp = p[i];
                            p[i] = q[t];
                            q[t] = temp;
                            res++;
                        }
                    }
                }
            }
            if (i > 0) {
                if (q[i] > q[i + 1]) {
                    if (i > 0) {
                        if (p[i] < q[i + 1] && q[i] >= p[i - 1]) {
                            int temp = p[i];
                            p[i] = q[i];
                            q[i] = temp;
                            res++;
                        }
                    } else if (p[i] < q[i + 1] && q[i] < p[i - 1]) {
                        for (int t = i; t > 0; t--) {
                            if (q[i] >= p[t - 1]) {
                                int temp = q[i];
                                q[i] = p[t - 1];
                                p[t - 1] = temp;
                                res++;
                            }
                        }
                    }
                } else {
                    for (int t = i + 1; t < n; t++) {
                        if (q[i] >= p[t - 1]) {
                            int temp = p[t];
                            p[t] = q[i];
                            q[i] = temp;
                            res++;
                        }
                    }
                }
            }
        }
        System.out.print(res);
    }
}