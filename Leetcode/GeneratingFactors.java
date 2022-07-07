package Leetcode;

import java.util.Scanner;

public class GeneratingFactors {
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        for(int i=1; i*i<n; i++){
            if(n%i==0){
                System.out.print(i*i!=n ? i +" "+(n/i)+" " : i +" ");
            }
        }
    }
}
