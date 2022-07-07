package Leetcode;

import java.util.Scanner;

public class PrimeRange {
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        boolean[] sieve = new boolean[n+1];
        for(int i=2; i<=n; i++){
            sieve[i] = true;
        }
        for(int i=2; i*i<=n; i++){
            if(sieve[i]){
                for(int j=i*i; j<=n; j+=i){
                    sieve[j] = false;
                }
            }
        }
        for(int i=2; i<=n; i++){
            if(sieve[i])
            System.out.print(i+" ");
        }
    }
}
