package Leetcode; // don't place package name! */

import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class AllCommonDivisors {
    public static int findGCD(int a, int b) {
        int divisor = Math.min(a, b);
        int dividend = Math.max(a, b);
        while (divisor != 1) {
            int remainder = dividend % divisor;
            if (remainder == 0) {
                return divisor;
            }
            dividend = divisor;
            divisor = remainder;
        }
        return divisor;
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        int t;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        while (t >= 1) {
            int a, b;
            a = s.nextInt();
            b = s.nextInt();
            int gcd = findGCD(a, b);
            int count = 0;
            for (int i = 1; (long) i * (long) i <= gcd; i++) {
                if (a % i == 0 && b % i == 0) {
                    if (i * i != gcd) {
                        count += 2;
                    } else {
                        count += 1;
                    }
                }
            }
            System.out.println(count);
            t--;
        }
    }
}