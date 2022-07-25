package Leetcode; // don't place package name! */

import java.util.Arrays;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class PrimePermutation {
    static final int M = 1000000007;

    public static long findFactorial(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = (ans % M * i % M) % M;
        }
        return ans;
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        final int N = 101;
        boolean[] primes = new boolean[N];
        int[] primeCounts = new int[N];
        Arrays.fill(primes, 2, N, true);

        for (int i = 2; i * i < N; i++) {
            if (primes[i]) {
                for (int j = i * i; j < N; j += i) {
                    primes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < N; i++) {
            primeCounts[i] = count;
            if (primes[i]) {
                count++;
            }
        }
        primes = null;
        int t;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        while (t >= 1) {
            int n = s.nextInt();
            System.out.println(primeCounts[n]);
            long ans = ((findFactorial(primeCounts[n]) % M) * (findFactorial(n - primeCounts[n]) % M)) % M;
            System.out.println(ans);
            t--;
        }
    }
}