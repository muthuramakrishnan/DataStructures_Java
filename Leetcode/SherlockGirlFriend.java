package Leetcode;

import java.util.Scanner;

public class SherlockGirlFriend {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt() + 2;
        int[] isPrime = new int[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = i;
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == i) {
                for (int j = i; (long) j * (long) i < n; j++) {
                    if(isPrime[i * j] == i*j){
                        isPrime[i*j] = i;
                    }
                }
            }
        }

        int[] counts = new int[n];
        int total = 1;
        for (int i = 2; i < n; i++) {
            if(isPrime[i]!=i){
                //definitely the number is not prime & it has some prime factor
                //if it has prime factor increment the count
                counts[i] = 2;
                total=2;
            }
            else {
                counts[i]=1;
            }
        }
        System.out.println(total);
        for (int i=2; i<n; i++){
            System.out.print(counts[i]+" ");
        }
    }
}