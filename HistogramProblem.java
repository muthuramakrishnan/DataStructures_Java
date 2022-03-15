import java.util.Scanner;

public class HistogramProblem {
    public static void main(String[] args){
        int n;
        int[] heights;
        Scanner s = new Scanner(System.in);
        n=s.nextInt();
        heights = new int[n];
        for(int i=0; i<n; i++){
            heights[i] = s.nextInt();
        }

        //calculating total water trapped
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = heights[0];
        suffixMax[n-1] = heights[n-1];

        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], heights[i]);
        }
        for(int i=n-2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], heights[i]);
        }

        int totalWaterTrapped = 0;
        for(int i=1; i<n-1; i++){
            if(heights[i]<prefixMax[i-1] && heights[i]<suffixMax[i+1]){
                int shortPillarHeight = Math.min(prefixMax[i-1], suffixMax[i+1]);
                totalWaterTrapped += shortPillarHeight - heights[i];
            }
        }
        System.out.println(totalWaterTrapped);
    }
}
