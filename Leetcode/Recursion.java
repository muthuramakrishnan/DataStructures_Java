package Leetcode;

import java.util.Scanner;

public class Recursion {
    //count distinct paths
    public static int findCount(int m, int n){
        if(m==0 || n==0){
            return 1;
        }
        return findCount(m-1, n) + findCount(m, n-1);
    }
    public static void main(String[] args){
        int m, n;
        Scanner s = new Scanner(System.in);
        m = s.nextInt();
        n = s.nextInt();

        System.out.println(findCount(m-1,n-1));
    }
}
