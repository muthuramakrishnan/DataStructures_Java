package Leetcode;

import java.util.Scanner;

public class LCM1 {
    public static int gcd(int a, int b){
        int divisor = Math.min(a,b);
        int dividend = Math.max(a,b);
        while(divisor!=1){
            int remainder = dividend % divisor;
            if(remainder==0){
                return divisor;
            }
            dividend = divisor;
            divisor = remainder;
        }
        return 1;
    }
    public static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }
    public static void main(String[] args) {
        //find the count of numbers that is divisible by A or divisble by B
        int n, a, b;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        a = s.nextInt();
        b = s.nextInt();
        int divisibleByA = n/a;
        int divisibleByB = n/b;
        int divisibleByAB = n / lcm(a,b);
        System.out.println(divisibleByA + divisibleByB - divisibleByAB);
    }
}
