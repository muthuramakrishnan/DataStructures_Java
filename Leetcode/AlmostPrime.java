/* package codechef; // don't place package name! */
package Leetcode;

import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class AlmostPrime {
    public static boolean isHappyPrime(int n, int[] sieve) {
        int currDivisor = sieve[n];
        int currCount = 1;
        while (n != 1) {
            if (currDivisor != sieve[n]) {
                currCount++;
                currDivisor = sieve[n];
            }
            n = n / sieve[n];
        }
        if (currCount == 2) {
            return true;
        }
        return false;
    }

    public static int[] findSieveArray() {
        final int N = 1000000;
        int[] sieve = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            sieve[i] = i;
        }
        for (int i = 2; (long) i * (long) i <= N; i++) {
            if (sieve[i] == i) {
                for (int j = i; (long) i * (long) j <= N; j++) {
                    if (sieve[i * j] == i * j) {
                        sieve[i * j] = i;
                    }
                }
            }
        }
        return sieve;
    }

    public static void main(String[] args) throws java.lang.Exception {
        int[] sieve = findSieveArray();
        Scanner s = new Scanner(System.in);
        // int t = s.nextInt();
        // while(t>=1){
        int n = s.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isHappyPrime(i, sieve)) {
                count++;
            }
        }
        System.out.println(count);
        // t--;
        // }
    }
}