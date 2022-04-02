import java.util.Scanner;

public class GeneratingFactors {
    public static void optimizedApproach(int n){
        //O(sqrt(n))
        for(int i=1; i*i<=n; i++){
            int mirrorFactor = n/i;

            if(mirrorFactor!=i){
                System.out.println(i);
                System.out.println(mirrorFactor);
            }
        }
    }
    public static void generateFactorsBruteForce(int n){
        //1st optimization is n/2
        for(int i=1; i<=n/2; i++){
            if(n%i==0){
                System.out.println(i);
            }
        }
        System.out.println(n);
    }
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n=s.nextInt();

//        generateFactorsBruteForce(n);
        optimizedApproach(n);
    }
}
