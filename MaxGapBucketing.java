import java.util.Scanner;

public class MaxGapBucketing {
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n=s.nextInt();

        if(n<0){
            System.out.println(0);
            return;
        }
        int[] array = new int[n];
        int minEle = Integer.MAX_VALUE;
        int maxEle = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
            minEle = Math.min(array[i], minEle);
            maxEle = Math.max(array[i], maxEle);
        }

        int minGap = (maxEle - minEle) / (n-1);
        if((maxEle - minEle) % (n-1) !=0) minGap++;

        if(minGap == 0){
            System.out.println(0);
            return;
        }

        int[] minElementBucket = new int[n];
        int[] maxElementBucket = new int[n];
        for(int i=0; i<n; i++){
            minElementBucket[i] = Integer.MAX_VALUE;
            maxElementBucket[i] = Integer.MIN_VALUE;
        }
        for(int i=0; i<n; i++){
            int bucketNo = (array[i] - minEle) / minGap;
            minElementBucket[i] = Math.min(minElementBucket[bucketNo], array[i]);
            maxElementBucket[i] = Math.max(maxElementBucket[bucketNo], array[i]);
        }

        int ans = Integer.MIN_VALUE;
        int prev = Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            if(minElementBucket[i] == Integer.MAX_VALUE)
            {
                continue;
            }
            if(prev == Integer.MIN_VALUE){
                prev = maxElementBucket[i];
            }
            else{
                ans = Math.max(ans, minElementBucket[i] - prev);
                prev = maxElementBucket[i];
            }
        }
        System.out.println(ans);
    }
}
