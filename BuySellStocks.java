import java.util.Scanner;

public class BuySellStocks {
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

        int[] prefixMin = new int[n];
        int[] suffixMax = new int[n];
        int[] prefixMaxProfit = new int[n];
        int[] suffixMaxProfit = new int[n];
        prefixMin[0] = array[0];
        suffixMax[n-1] = array[n-1];
        prefixMaxProfit[0] = 0;
        suffixMaxProfit[n-1] = 0;
        int maxProfitGained = 0;
        for(int i=1; i<n; i++){
            prefixMin[i] = Math.min(prefixMin[i-1], array[i]);
            int currentProfit = array[i] - prefixMin[i-1];
            prefixMaxProfit[i] = Math.max(prefixMaxProfit[i-1], currentProfit);
        }
        for(int i=n-2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], array[i]);
            int currentProfit = suffixMax[i+1] - array[i];
            suffixMaxProfit[i] = Math.max(suffixMaxProfit[i+1], currentProfit);
        }

        for(int i=1; i<n; i++){
            maxProfitGained = Math.max(prefixMaxProfit[i] + suffixMaxProfit[i], maxProfitGained);
        }
        System.out.println(maxProfitGained);
    }
}
