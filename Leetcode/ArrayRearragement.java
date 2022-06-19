package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRearragement {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                int idx = arr[i];
                int value = i;
                while (idx != i) {
                    int newIdx = arr[idx];
                    int newValue = idx;
                    arr[idx] = -value - 1;
                    value = newValue;
                    idx = newIdx;
                }
                arr[idx] = -value-1;
            }
        }
        System.out.println(Arrays.toString(arr));
        for(int i=0; i<n; i++){
            System.out.print(-arr[i]-1 + " ");
        }
    }
}
