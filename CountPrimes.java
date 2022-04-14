import java.util.Arrays;
import java.util.Scanner;

public class CountPrimes {
    public static void main(String[] args){
        int t, n=10000000;
        Scanner s= new Scanner(System.in);
        int[] sieve = new int[n+1];

        //calculate the sieve array
        sieve[0] = sieve[1]  = 0;
        for(int i=2; i<=n; i++){
            sieve[i] = 1;
        }
        int count=0;
        for(int i=2; i<=n; i++){
            if(sieve[i]==1){
                count++;
                for(int j=i*i; j<=n && j>=1; j+=i){
                    sieve[j] = 0;
                }
            }
            sieve[i] = count;
        }
        System.out.println(Arrays.toString(sieve));
        t = s.nextInt();
        while(t>=1){
            int query = s.nextInt();
            System.out.println(sieve[query]);
            t--;
        }
    }
}
