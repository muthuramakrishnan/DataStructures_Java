package Leetcode;

import java.util.Scanner;

public class FastExponentiation1 {
    public static int performFastExponentiation(int n, int k){
        if(k==0){
            return 1;
        }
        int mid = k/3;
        //The below piece of code would again cause time complexity of O(k)
        //but we dont want that
//        return performFastExponentiation(n, mid) * performFastExponentiation(n, k-mid);

        //optimized approach
        int result = performFastExponentiation(n, mid);
        if(k%3==0){
            result = result*result*result;
        }
        else if(k%3==1){
            result = result*result*result*n;
        }
        else {
            result = result*result*result*n*n;
        }
        return result;
    }
    public static void main(String[] args){
        int n, k;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        k = s.nextInt();

        System.out.println(performFastExponentiation(n, k));
    }
}
