package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDPrefixSum {
    public static int[][] calculatePrefixSumMethod2(int[][] array, int m, int n){
        int[][] result = new int[m][n];
        result[0][0] = array[0][0];
//        for(int j=1; j<n; j++){
//            result[0][j] = result[0][j-1] + array[0][j];
//        }
//        for(int i=1; i<m; i++){
//            result[i][0] = result[i-1][0] + array[i][0];
//        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result[i][j] = array[i][j];
                if(j>0){
                    result[i][j] += result[i][j-1];
                }
                if(i>0){
                    result[i][j] += result[i-1][j];
                }
                if(j>0 && i>0){
                    result[i][j] -= result[i-1][j-1];
                }
            }
        }
        return result;
    }
    public static int[][] calculatePrefixSumMethod1(int[][] array, int m, int n){
        int[][] result = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //row wise addition
                result[i][j] = array[i][j];
                if(j>0){
                    result[i][j] += result[i][j-1];
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //column wise addition
                if(i>0){
                    result[i][j] += result[i-1][j];
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int m, n;
        Scanner s = new Scanner(System.in);
        m = s.nextInt();
        n = s.nextInt();

        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = s.nextInt();
            }
        }

//        int[][] result = calculatePrefixSumMethod1(arr, m, n);
        int[][] result = calculatePrefixSumMethod2(arr, m, n);
        for(int i=0; i<m; i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
