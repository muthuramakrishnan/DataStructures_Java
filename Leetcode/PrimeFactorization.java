package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorization {
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        List<Integer> factors = new ArrayList<>();
        factors.add(1);
        for(int i=2; i*i<=n; i++){
            while(n%i==0){
                factors.add(i);
                n=n/i;
            }
        }
        if(n!=1){
            factors.add(n);
        }
        System.out.println(factors);
    }
}
