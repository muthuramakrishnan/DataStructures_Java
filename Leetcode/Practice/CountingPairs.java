package Leetcode.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class CountingPairs {
    public static int findCombination(int n, int r) {
        int ans = 1;
        int divisor = 1;
        for (int i = n; i > n - r; i--) {
            ans *= i;
        }
        for (int i = 1; i <= divisor; i++) {
            divisor *= i;
        }
        return ans / divisor;
    }

    public static void main(String[] args) {
        int n, k;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        k = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int[] buckets = new int[k];
        Arrays.fill(buckets, 0);
        for (int i = 0; i < n; i++) {
            buckets[arr[i] % k]++;
        }

        int ans = findCombination(buckets[0], 2);
        int i = 1;
        for (; i <= k / 2 - 1; i++) {
            ans += arr[i] * arr[k - i];
        }
        if (k % 2 != 0) {
            ans += findCombination(buckets[i], 2);
        } else {
            ans += arr[i] * arr[i + 1];
        }
        System.out.println(ans);
    }
}
