package Leetcode.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SegmentedSieve {
    public static void main(String[] args) throws IOException {
        //N is root of r
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N];
        Arrays.fill(isPrime, 2, N, true);
        for (int i = 2; (long) i * i < N; i++) {
            if (isPrime[i]) {
                for (int j = i; (long) i * j < N; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i*i < N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }


        int q = Integer.parseInt(br.readLine());
        while(q>=1){
            int l, r;
            StringTokenizer str = new StringTokenizer(br.readLine());
            l = Integer.parseInt(str.nextToken());
            r = Integer.parseInt(str.nextToken());
            isPrime = new boolean[r-l+1];
            Arrays.fill(isPrime, true);
            for(int prime : primes){
                int startIdx = (int) Math.ceil((double) l / prime);
                for(int j=startIdx; (long)prime*j<=r; j++){
                    if(isPrime[(prime*j)-l]){
                        isPrime[(prime*j)-l] = false;
                    }
                }
            }
            for(int i=0; i<=r-l; i++){
                if(isPrime[i]){
                    System.out.println(l+i);
                }
            }
            q--;
        }
    }
}
