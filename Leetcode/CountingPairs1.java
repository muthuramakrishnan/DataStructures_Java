package Leetcode; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class CountingPairs1
{
    public static int findCombination(int n, int r){
        int ans = 1;
        int count = 0;
        int denom = 1;
        for(int i=n; i>n-r; i--){
            ans *= i;
            count++;
            denom *= count;
        }
        return ans / denom;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        final int m = 4;
        int t;
        BufferedReader ip = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(ip.readLine());
        while(t>=1){
            int n;
            n = Integer.parseInt(ip.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(ip.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] counts = new int[m];
            for(int i=0; i<n; i++){
                counts[arr[i]%m]++;
            }
            System.out.println(Arrays.toString(counts));
            int ans=0;
            ans += findCombination(counts[0], 2);
//            System.out.println(ans);
            int i;
            for(i=1; i<=m/2-1; i++){
                ans += counts[i] * counts[m-i];
            }
//            System.out.println(ans);
            if(m%2==0){
                ans += findCombination(counts[i],2);
            }
            else{
                ans += counts[i] * counts[i+1];
            }
            System.out.println(ans);
            t--;
        }
    }
}