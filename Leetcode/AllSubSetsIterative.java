package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AllSubSetsIterative {
    public static int[] getBinarNum(int num, int n){
        int[] bit = new int[n];
        for(int i=n-1; i>=0; i--){
            bit[i] = num%2;
            if(num!=0){
                num = num/2;
            }
        }
        return bit;
    }
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }
        int powN2 = (int)Math.pow(2,n);
        for(int i=0; i<powN2; i++){
            int[] binaryNum = getBinarNum(i, n);
            StringBuffer outputStr = new StringBuffer();
            for(int j=0; j<binaryNum.length; j++){
                if(binaryNum[j]==1){
                    outputStr.append(arr[j]);
                }
            }
            System.out.println(outputStr);
        }
    }
}
