package Leetcode;

import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class SumOfProperDivisors {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        int t;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        while (t >= 1) {
            int n = s.nextInt();
            int count = 0;
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    count += i;
                    if (i * i != n && i!=1) {
                        count += n / i;
                    }
                }
            }
            System.out.println(count);
            t--;
        }
    }
}