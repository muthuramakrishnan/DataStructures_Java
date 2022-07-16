package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SegmentedSieve {
    public static void main(String[] args) {
        int l, r;
        Scanner s = new Scanner(System.in);
        l = s.nextInt();
        r = s.nextInt();
        boolean[] isPrime = new boolean[(int) Math.ceil(Math.sqrt(r) + 1)];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i; j * i < isPrime.length; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        isPrime = new boolean[r - l + 1];
        for (int i = 0; i <= r - l; i++) {
            isPrime[i] = true;
        }

        for (int prime : primes) {
            int startIdx = (int)Math.ceil((double)l/prime);
            for (int i = startIdx; i * prime <= r; i++) {
                int originalIdx = (prime * i) - l;
                isPrime[originalIdx] = false;
            }
        }
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.println(i + l);
            }
        }
    }
}
