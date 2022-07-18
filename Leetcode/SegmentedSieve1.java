package Leetcode; // don't place package name! */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class SegmentedSieve1
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int t;
        final int m = 1000000007;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, 2, 1000001, true);
        for(int i=2; (long)i*i<isPrime.length; i++){
            if(isPrime[i]){
                for(int j=i; (long)i*j<isPrime.length; j++){
                    isPrime[i*j]=false;
                }
            }
        }

        List<Integer> primes = new ArrayList();
        for(int i=2; i<isPrime.length; i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }

        while(t>=1){
            int l, r;
            l = s.nextInt();
            r = s.nextInt();

            isPrime = new boolean[1000001];
            Arrays.fill(isPrime, true);

            for(int prime : primes){
                int startIdx = (int) Math.ceil((double)l/prime);
                for(int j=Math.max(startIdx,2); (long)j*prime<=r; j++){
                    int originalIdx = (prime*j)-l;
                    isPrime[originalIdx] = false;
                }
            }
            long ans=1;
            for (int i = 0; i < r-l+1; i++) {
                if (isPrime[i]) {
                    ans = (ans%m * (i+l)%m)%m;
                }
            }
            System.out.println(ans);
            t--;
        }

    }
}