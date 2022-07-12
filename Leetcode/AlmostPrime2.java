/* package Leetcode; // don't place package name! */
package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class AlmostPrime2
{
    public static void main (String[] args) throws java.lang.Exception
    {
        final int N = 1000000;
        int[] sieve = new int[N+1];
        int[] factors = new int[N+1];
        int[] prefixCount = new int[N+1];
        Arrays.fill(sieve, 2, N, 1);
        Arrays.fill(factors, 0);
        for(int i=2; i<=N; i++){
            if(sieve[i]==1){
                for(int j=2; (long)i*(long)j<=N; j++){
                    factors[i*j]++;
                    sieve[i*j]=0;
                }
            }
        }
        for(int i=2; i<=N; i++){
            if(factors[i]==2){
                prefixCount[i] = prefixCount[i-1]+1;
            }
            else{
                prefixCount[i] = prefixCount[i-1];
            }
        }
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>=1){
            int n = s.nextInt();
            System.out.println(prefixCount[n]);
            t--;
        }
    }
}