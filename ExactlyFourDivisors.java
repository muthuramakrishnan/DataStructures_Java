import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExactlyFourDivisors {
    public static int getSumOfDivisors(int n){
        List<Integer> divisors = new ArrayList<>();
        int sqrtOfN = (int)Math.sqrt(n);
        int length = 0, sum=0;
        if(sqrtOfN * sqrtOfN == n) return 0;
        for(int i=1; i*i<=n; i++){
            if(n%i==0){
                divisors.add(i);
                if(i*i!=n){
                    divisors.add(n/i);
                }
            }
        }
        length = divisors.size();
        if(length==4){
            for(int elm : divisors){
                sum += elm;
            }
        }
        return sum;
    }
    public static void main(String[] args)  throws java.lang.Exception{
        int t, n;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();

       while(t>=1){
           n = s.nextInt();
           int[] array = new int[n];
           for (int i=0; i<n; i++){
               array[i] = s.nextInt();
           }

           int sum=0;
           for(int i=0; i<n; i++){
                sum += getSumOfDivisors(array[i]);
           }
           System.out.println(sum);
           t--;
       }
    }
}
