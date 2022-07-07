package Leetcode;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        boolean isPrime = true;
        if(n==1){
            isPrime = false;
        }
        for(int i=2; i*i<=n; i++){
            if(n%i==0){
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime);
    }
}
