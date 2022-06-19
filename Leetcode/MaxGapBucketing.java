package Leetcode;

import java.util.Scanner;

public class MaxGapBucketing {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        if (n < 1) {
            System.out.println(0);
        }
        int[] arr = new int[n];
        int minEle = Integer.MAX_VALUE;
        int maxEle = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            minEle = Math.min(minEle, arr[i]);
            maxEle = Math.max(maxEle, arr[i]);
        }

        if (minEle == maxEle) {
            System.out.println(0);
        }

        int gap = (maxEle - minEle) / (n + 1);
        if ((maxEle - minEle) % (n + 1) != 0) {
            gap++;
        }
        int[] minElBucket = new int[n];
        int[] maxElBucket = new int[n];
        for (int i = 0; i < n; i++) {
            minElBucket[i] = Integer.MAX_VALUE;
            maxElBucket[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            int bucketNum = (arr[i] - minEle) / gap;
            minElBucket[bucketNum] = Math.min(minElBucket[bucketNum], arr[i]);
            maxElBucket[bucketNum] = Math.max(maxElBucket[bucketNum], arr[i]);
        }

        int ans = Integer.MIN_VALUE;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (minElBucket[i] == Integer.MAX_VALUE) {
                //if min element is null then it will not have maxElement at all
                continue;
            }
            if (prev != Integer.MIN_VALUE) {
                ans = Math.max(ans, minElBucket[i] - prev);
                prev = maxElBucket[i];
            } else {
                prev = maxElBucket[i];
            }
        }
    }
}
