package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DivideAndConquer {
    public static int findMax(int i, int j, int[] arr){
        if(i==j){
            return arr[i];
        }
        int mid = (i+j)/2;
        return Math.max(findMax(i, mid, arr), findMax(mid+1, j, arr));
    }
    public static void main(String[] args)throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        //find max in the array using divide and conquer
        System.out.println(findMax(0, n-1, arr));
    }
}
