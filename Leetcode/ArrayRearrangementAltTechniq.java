package Leetcode;

import java.util.Scanner;

public class ArrayRearrangementAltTechniq {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int newIdx = arr[i] % n;
            arr[newIdx] = n * i + arr[newIdx];
        }

        for(int i=0; i<n; i++){
            System.out.println(arr[i]/n);
        }
    }
}
