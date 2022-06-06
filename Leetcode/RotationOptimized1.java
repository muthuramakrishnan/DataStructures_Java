package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class RotationOptimized1 {
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

        int k = s.nextInt();
        k = k%n;
        int[] resultArray = new int[n];
        for(int i=0; i<n; i++){
            resultArray[(k+i)%n] = array[i];
        }

        System.out.println(Arrays.toString(resultArray));
    }
}
