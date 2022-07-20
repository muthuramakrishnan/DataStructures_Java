package Leetcode;

import java.util.Scanner;

public class FactorialUsingPascalTriangle {
    public static void main(String[] args) {
        int n, m, t;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        t = s.nextInt();
        //N boys & M girls are there
        //Need to choose T people out of them
        //Having no less than 4 boys and 1 girl
        // 4<=n<=30, 1<=m<=30, 5<=T<=n+m

        long[][] pascalTriangle = new long[61][61];
        pascalTriangle[0][0] = 1L;
        for (int i = 1; i <= 60; i++) {
            for (int j = 0; j <= 60; j++) {
                if (j == 0 || j == i) {
                    pascalTriangle[i][j] = 1L;
                } else {
                    pascalTriangle[i][j] = pascalTriangle[i - 1][j] + pascalTriangle[i - 1][j - 1];
                }
            }
        }
//        for(int i=0; i<=60; i++){
//            for (int j=0; j<=60; j++){
//                System.out.print(pascalTriangle[i][j] +" ");
//            }
//            System.out.println();
//        }

        //0BoysTgirls, 1BoyT-1girls, 2BoysT-2Girls, 3BoysT-3Girls, 0GirlsTBoys
        int ans = 0;
        for (int i = 0; i <= 3; i++) {
            if (t - i <= m)
                ans += pascalTriangle[n][i] * pascalTriangle[m][t - i];
        }
        if (t <= n)
            ans += pascalTriangle[m][0] * pascalTriangle[n][t];
        System.out.println(pascalTriangle[n + m][t] - ans);
    }
}
