import java.util.Scanner;

public class Lcm1 {
    public static int findGCD(int a, int b){
        int divisor = Math.min(a, b);
        int dividend = Math.max(a, b);

        while(divisor>1){
            int remainder = dividend % divisor;
            if(remainder==0){
                return divisor;
            }
            dividend = divisor;
            divisor = remainder;
        }
        return 1;
    }
    public static int findLCMCount(int a, int b){
        int lb = Math.max(a,b);
        int ub = a*b;
        return (lb*ub)/findGCD(lb, ub);
    }
    public static void main(String[] args){
        int n, a, b;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        a = s.nextInt();
        b = s.nextInt();

        //find number of elements that are divisible either by a or by b
        //brute force approach is to iterate all the elements and get the count

        //optimized approach - LCM
        int lcmCount = findLCMCount(a, b);
        System.out.println((n/a) + (n/b) - (n/lcmCount));

    }
}
