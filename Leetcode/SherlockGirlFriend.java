package Leetcode;

import java.util.Scanner;

public class SherlockGirlFriend {
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt() + 2;
        int[] sieve = new int[n];
        for(int i=2; i<n; i++){
            sieve[i] = i;
        }
        for(int i=2; i<n; i++){
            if(sieve[i]==i){
                for(int j=i; (long)j*(long)i<n; j++){
                    if(sieve[i*j]==i*j){
                        sieve[i*j] = i;
                    }
                }
            }
        }
        int count=1;
        for(int i=2; i<n; i++){
            if(i+1<n && sieve[i+1]!=i+1){
                count++;
            }
        }
        System.out.println(count);
        count=1;
        for(int i=2; i<n; i++){
            System.out.print(count+" ");
            if(i+1<n && sieve[i+1]!=i+1){
                count++;
            }
        }
    }
}
