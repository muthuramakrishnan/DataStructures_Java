package Leetcode;

import java.util.Scanner;

public class FourDivisors {
    public static int findDivisors(int n){
        int ans=0;
        int count=0;
        for(int i=1; i*i<=n; i++){
            if(n%i==0){
                ans += i;
                count++;
                if(i*i!=n){
                    ans += n/i;
                    count++;
                }
            }
        }
        if(count==4){
            return ans;
        }
        else{
            return 0;
        }
    }
    public static int sumFourDivisors(int[] arr) {
        int ans=0;
        for(int i=0; i<arr.length; i++){
            ans += findDivisors(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = s.nextInt();
        }

        System.out.println(sumFourDivisors(arr));
    }
}
