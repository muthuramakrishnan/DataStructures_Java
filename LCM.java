import java.util.Scanner;

public class LCM {
    public static int findLcm(int n1, int n2){
        //lcm lower bound is max(n1, n2)
        //lcm upper bound is n1*n2

        int lb = Math.max(n1, n2);
        int up = n1*n2;
        for(int i=lb; i<=up; i++){
            if(i%n1==0 && i%n2==0){
                return i;
            }
        }
        return up;
    }
    public static void main(String[] args){
        int n1, n2;
        Scanner s = new Scanner(System.in);
        n1 = s.nextInt();
        n2 = s.nextInt();

        int lcm = findLcm(n1, n2);
        System.out.println(lcm);

    }
}
