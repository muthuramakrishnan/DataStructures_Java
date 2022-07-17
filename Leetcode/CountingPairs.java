package Leetcode;

import java.util.Scanner;

public class CountingPairs {
    public static int findNC2(int n) {
        return (n * (n - 1)) / 2;
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

        int[] counts = new int[k];
        for (int i = 0; i < n; i++) {
            counts[arr[i] % k]++;
        }

        int ans = 0;
        //find nc2;
        ans += findNC2(counts[0]);
        int i;
        for (i = 1; i <= k / 2 - 1; i++) {
            ans += counts[i] * counts[k - i];
        }
        if (k % 2 == 0) {
            ans += findNC2(counts[i]);
        } else {
            ans += counts[i] * counts[i + 1];
        }
        System.out.println(ans);
    }
}
