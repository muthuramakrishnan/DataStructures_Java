import java.util.Scanner;

public class GCDArray {
    public static int findGcd(int n1, int n2){
        int dividend = Math.max(n1, n2);
        int divisor = Math.min(n1, n2);
        while(divisor>=1){
            int remainder = dividend%divisor;
            if(remainder==0){
                return divisor;
            }
            else{
                dividend = divisor;
                divisor = remainder;
            }
        }
        return divisor;
    }
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

        int gcd = findGcd(array[0], array[1]);
        for(int i=2; i<n; i++){
            gcd = findGcd(gcd, array[i]);
        }
        System.out.println(gcd);
    }
}
