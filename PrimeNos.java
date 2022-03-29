import java.util.Scanner;

public class PrimeNos {
    public static boolean isPrimeBruteForce(long n){
        //here itself optimization 1 is done
        //just iterate till sqrt(n).
        for(long i=2; i*i<=n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        boolean isPrime = isPrimeBruteForce(n);
        System.out.println(isPrime);
    }
}
