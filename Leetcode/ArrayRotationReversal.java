package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotationReversal {
    public static void reverseArray(int[] array, int l, int r){
        while(l<r){
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = s.nextInt();
        }

        int k = s.nextInt();
        k = k % n;
        reverseArray(array, 0, n-1);
        reverseArray(array, 0, k-1);
        reverseArray(array, k, n-1);
        System.out.println(Arrays.toString(array));
    }
}
