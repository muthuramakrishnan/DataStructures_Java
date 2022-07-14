/* package codechef; // don't place package name! */
package Leetcode;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class TPrime
{
    //This works only for n=10^5 but question asks for 10^9, still needs to be optimized
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        final int N = 100000;
        int[] primes = new int[N+1];
        for(int i=2; i<=N; i++){
            primes[i] = 1;
        }
        for(int i=2; i<=N; i++){
            if(primes[i]==1){
                for(int j=i; (long)i*(long)j<=N; j++){
                    if(i==j){
                        primes[i*j] = i*j;
                    }
                    else
                        primes[i*j] = primes[i*j]!=0 ? primes[i*j]*i : i;
                }
            }
        }
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>=1){
            int n = s.nextInt();
            int count=0;
            for(int i=0; i<n; i++){
                int x = s.nextInt();
                if(primes[x]==x && x!=1){
                    count+=x;
                }
            }
            System.out.println(count);
            t--;
        }
    }
}