package Leetcode;

import java.util.Scanner;

public class CountingPairs3Nums {
    public static int findCombination(int n, int r) {
        int ans = 1;
        int count = 0;
        int denom = 1;
        for (int i = n; i >= n - r; i--) {
            ans *= i;
            count++;
            denom *= count;
        }
        return ans / denom;

    }

    public static void main(String[] args) {
        int n, m;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int[] counts = new int[m];
        for (int i = 0; i < n; i++) {
            counts[arr[i] % m]++;
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            //j should be equal to i and not j=0
            //reason --> After considering 0 2 6, 2 0 6 should not be considered
            for (int j = i; j < m; j++) {
                int k;
                if ((i + j) % m == 0) {
                    k = 0;
                } else {
                    k = m - (i + j) % m;
                }
                //also, k should not be less than j
                //reason --> after considering 0 6 2, 0 2 6 should not be re-considered
                if (k < j) {
                    continue;
                } else {
                    if ((i == j) && (j == k)) {
                        ans += findCombination(counts[i], 3);
                    } else if (i == j) {
                        ans += findCombination(counts[i], 2) * counts[k];
                    } else if (i == k) {
                        ans += findCombination(counts[i], 2) * counts[j];
                    } else if (j == k) {
                        ans += findCombination(counts[j], 2) * counts[i];
                    } else {
                        ans += counts[i] + counts[j] + counts[k];
                    }
                }
            }
        }
        System.out.print(ans);
    }
}
