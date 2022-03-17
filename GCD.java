import java.util.Scanner;

public class GCD {
    public static void findGCDBruteForce(int n1, int n2){
        int maxNo = Math.max(n1,n2);
        int gcd = 1;
        while(maxNo>1){
            if(n1%maxNo==0 && n2%maxNo==0){
                gcd = maxNo;
                break;
            }
            maxNo--;
        }
        System.out.println(gcd);
    }
    public static void main(String[] args){
        int n1, n2;
        Scanner s = new Scanner(System.in);
        n1 = s.nextInt();
        n2 = s.nextInt();

        findGCDBruteForce(n1, n2);
    }
}
