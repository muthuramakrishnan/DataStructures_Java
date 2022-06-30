package Leetcode;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args){
        int a,b;
        Scanner s = new Scanner(System.in);
        a = s.nextInt();
        b = s.nextInt();

        int divisor = Math.min(a,b);
        int dividend = Math.max(a,b);
        while(divisor!=1){
            int remainder = dividend % divisor;
            if(remainder==0){
                System.out.println(divisor);
                System.exit(0);
            }
            dividend = divisor;
            divisor = remainder;
        }
        System.out.println(divisor);
    }
}
