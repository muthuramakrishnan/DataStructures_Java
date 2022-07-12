package Leetcode;

import java.util.Scanner;

public class FastFactorization {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] sieve = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            sieve[i] = i;
        }

        for (int i = 2; i * i <= n; i++) {
            if (sieve[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    sieve[j] = i;
                }
            }
        }

        while (n != 1) {
            System.out.println(sieve[n]);
            n = n / sieve[n];
        }
    }
}
