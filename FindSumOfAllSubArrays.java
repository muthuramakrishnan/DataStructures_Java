import java.util.Scanner;

public class FindSumOfAllSubArrays {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n;
        n = s.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

        final int m = 1000000007;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum = (sum%m + (((i+1)%m * (n-i)%m)%m * array[i]%m)%m)%m;
        }
        System.out.println(sum);
    }
}
