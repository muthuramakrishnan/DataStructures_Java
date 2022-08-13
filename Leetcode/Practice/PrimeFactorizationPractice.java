package Leetcode.Practice;

import java.util.*;

public class PrimeFactorizationPractice {
    public static List<Integer> performPrimeFactorization(int n){
        int nCopy = n;
        Set<Integer> primeFactors = new HashSet<>();
        for(int i=2; i*i<=n; i++){
            while(nCopy%i==0){
                primeFactors.add(i);
                nCopy=nCopy/i;
            }
        }
        if(nCopy!=1){
            primeFactors.add(nCopy);
        }
        return new ArrayList<>(primeFactors);
    }
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        List<Integer> result = performPrimeFactorization(n);
        System.out.print(result);
    }
}
