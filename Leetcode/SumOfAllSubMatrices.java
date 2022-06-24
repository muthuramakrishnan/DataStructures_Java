package Leetcode;

import java.util.Scanner;

public class SumOfAllSubMatrices {
    public static void main(String[] args){
        int m, n;
        Scanner s = new Scanner(System.in);
        m = s.nextInt();
        n = s.nextInt();

        int[][] array = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                array[i][j] = s.nextInt();
            }
        }

        long result=0;
        long mod = 1000000007;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result = (((i+1) * (j+1) * (m-i) * (n-j) * (array[i][j]%mod))%mod + result%mod)%mod;
            }
        }
        System.out.println(result);
    }
}
