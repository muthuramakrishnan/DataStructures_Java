package Leetcode;

import java.util.Scanner;

public class FastExponentiation {
    public static int performFastExponentiation(int n, int k){
        if(k==1){
            return n;
        }
        int mid = k/2;
        //The below piece of code would again cause time complexity of O(k)
        //but we dont want that
//        return performFastExponentiation(n, mid) * performFastExponentiation(n, k-mid);

        //optimized approach
        int result = performFastExponentiation(n, mid);
        if(k%2==0){
            result = result*result;
        }
        else{
            result = result * result * n;
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
