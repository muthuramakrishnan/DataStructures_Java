package Leetcode;

import java.util.Scanner;

public class SuperDigit {
    public static int findSuperDigit(int n, int k) {
        int total = 0;
        if(n%10 == n){
            return n;
        }
        while (n != 0) {
            total += n % 10;
            n /= 10;
        }
        total *= k;
        return findSuperDigit(total, 1);
    }

    public static void main(String[] args) {
        int n, k;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        k = s.nextInt();
        System.out.println(findSuperDigit(n, k));
    }
}
