package Leetcode;

import java.util.Scanner;

public class PrimeFactorizationMultipleQueries {
    public static void main (String[] args) throws java.lang.Exception
    {
        final int N = 1000000;
        int[] sieve = new int[N+1];

        for(int i=2; i<=N; i++){
            sieve[i]=i;
        }
        for(int i=2; (long)i*(long)i<=N; i++){
            if(sieve[i]==i){
                for(int j=i; (long)i*(long)j<=N; j++){
                    sieve[i*j]=i;
                }
            }
        }
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>=1){
            int n=s.nextInt();
            int currCount=0;
            int currDivisor=sieve[n];
            while(n!=1){
                if(sieve[n]==currDivisor){
                    currCount++;
                }
                else{
                    System.out.println(currDivisor +" "+ currCount);
                    currCount=1;
                    currDivisor=sieve[n];
                }
                n=n/sieve[n];
            }
            System.out.println(currDivisor +" "+ currCount);
            t--;
        }
    }
}
