package Leetcode;

import java.util.Scanner;

public class LCM {
    public static int findGCD(int a, int b){
        int divisor = Math.min(a,b);
        int dividend = Math.max(a,b);
        while(divisor!=1){
            int remainder = dividend % divisor;
            if(remainder==0){
                return  divisor;
            }
            dividend = divisor;
            divisor = remainder;
        }
        return  divisor;
    }
    public static int findLCM(int a, int b){
        return (a*b)/findGCD(a,b);
    }
    public static void main(String[] args){
        int a, b;
        Scanner s = new Scanner(System.in);
        a = s.nextInt();
        b = s.nextInt();

        int lcm = findLCM(a,b);
        System.out.println(lcm);
    }
}
