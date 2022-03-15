import java.util.Scanner;

public class MaximizeExpression {
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] array, prefixMax, suffixMax;
        array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

        int p,q,r;
        p = s.nextInt();
        q = s.nextInt();
        r = s.nextInt();

        prefixMax = new int[n];
        suffixMax = new int[n];
        prefixMax[0] = p * array[0];
        suffixMax[n-1] = r * array[n-1];

        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], p * array[i]);
        }
        for(int i=n-2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], r * array[i]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1; i<n-1; i++){
           int sum = prefixMax[i-1] + q * array[i] + suffixMax[i+1];
           ans = Math.max(sum, ans);
        }
        System.out.println(ans);
    }
}
