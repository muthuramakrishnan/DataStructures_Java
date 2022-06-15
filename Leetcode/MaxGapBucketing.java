package Leetcode;

import java.util.Scanner;

public class MaxGapBucketing {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        if (n < 2) System.out.println(0);

        int[] arr = new int[n];
        int maxEl = Integer.MIN_VALUE, minEl = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            maxEl = Math.max(maxEl, arr[i]);
            minEl = Math.min(minEl, arr[i]);
        }

        if (maxEl - minEl == 0) System.out.println(0);

        int gap = (maxEl - minEl)/(n-1);
        if((maxEl-minEl)/(n-1)!=0){
            gap++;
        }
        int[] minEleBucket = new int[n];
        int[] maxEleBucket = new int[n];
        for(int i=0; i<n; i++){
            minEleBucket[i] = Integer.MAX_VALUE;
            maxEleBucket[i] = Integer.MIN_VALUE;
        }
        for(int i=0; i<n; i++){
            //find out bucket number
            int bucketNo = (arr[i] - minEl) / gap;
            minEleBucket[bucketNo]=Math.min(minEleBucket[bucketNo], arr[i]);
            maxEleBucket[bucketNo] = Math.max(maxEleBucket[bucketNo], arr[i]);
        }

        //n buckets are there so n iterations
        int prev = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(minEleBucket[i]==Integer.MAX_VALUE){
                continue;
            }
            if(prev == Integer.MIN_VALUE){
                prev = maxEleBucket[i];
            }
            else{
                ans = Math.max(ans, minEleBucket[i] - prev);
                prev = maxEleBucket[i];
            }
        }
        System.out.println(ans);
    }
}
