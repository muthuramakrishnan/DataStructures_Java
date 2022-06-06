package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class ClockWiseRotation {
    public static void main(String[] args) {
        int n, k;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = s.nextInt();
        }

        k = s.nextInt();
        while (k >= 1) {
            int temp = array[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                array[i + 1] = array[i];
            }
            array[0] = temp;
            k--;
        }

        System.out.println(Arrays.toString(array));
    }
}
