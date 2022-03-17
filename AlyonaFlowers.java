import java.util.Scanner;

public class AlyonaFlowers {
    public static void main(String[] args){
        //alyona has some flowers which has some happiness
        //her mother suggests some sub arrays to her
        //she wants to choose some sub arrays among the suggestions such that her happiness is maixmum
        int n, k;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        k = s.nextInt();

        int[] flowers = new int[n];
        for(int i=0; i<n; i++){
            flowers[i] = s.nextInt();
        }

        int[] prefixSum = new int[n];
        prefixSum[0] = flowers[0];
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + flowers[i];
        }
        //simplifying the problem
        //it's basically the sum of all sub arrays and get the max out of it
        //get input from the user -> flowers suggested by her mother
        int maxHappiness = 0;
        while(k>=1){
            int l, r, sum;
            l = s.nextInt();
            r = s.nextInt();
            l--;
            r--;
            sum = prefixSum[r];
            if(l>0){
                sum -= prefixSum[l-1];
            }
            if(sum > 0){
                maxHappiness += sum;
            }
            k--;
        }
        System.out.println(maxHappiness);
    }
}
