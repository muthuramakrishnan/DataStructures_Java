package Leetcode.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastFactorization {
    final static int N = 1000001;
    static int[] spf = new int[N];

    public static int countFactors(int n){
        int count = 0;
        while(n!=1){
            n = n/spf[n];
            count++;
        }
        return count+1;
    }
    public static void main(String[] args) throws IOException {

        for(int i=2; i<N; i++){
            spf[i] = i;
        }

        for(int i=2; i<N; i++){
            for(int j=i; (long)i*j<N; j++){
                if(spf[i*j]==i*j){
                    spf[i*j] = i;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        while (q>=1){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer str = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(str.nextToken());
            }
            int ans=0;
            for(int i=0; i<n; i++){
                ans += countFactors(arr[i]);
            }
            System.out.println(ans);
            q--;
        }

    }
}
