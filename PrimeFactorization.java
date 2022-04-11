import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorization {
    public static boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2; i*i<n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void bruteForceApproach(int n){
        List<Integer> factors = new ArrayList<>();
        for(int i=2; i<=n; i++){
            if(isPrime(i)){ //no need of this condition check
                //because, while loop takes care of it
                while(n%i==0){
                    factors.add(i);
                    n = n/i;
                }
            }
        }
        System.out.println(factors);
    }
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        //brute force approach
        bruteForceApproach(n);
    }
}
