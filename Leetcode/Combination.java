package Leetcode;

import java.util.Scanner;

//This will not work as factorial cannot be computed for even numbers like 20
public class Combination {
    public static int findFact(int n){
        int ans=1;
        for(int i=1; i<=n; i++){
            ans*=i;
        }
        return ans;
    }
    public static int findCombination(int n, int r){
        int ans = 1;
        for(int i=n; i>n-r; i--){
            ans *= i;
        }
        return ans / findFact(r);
    }
    public static void main(String[] args){
        //N boys & M girls are there
        //Need to choose T people out of them
        //Having no less than 4 boys and 1 girl
        int m,n,t;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        t = s.nextInt();

        //find n+mCt
        int nct = findCombination(n+m, t);
        //find 0BoysTgirls, 1BoyT-1Girl, 2BoysT-2Girls, 3Boyst-3Girls
        //find TBoys0Girls
        int ans=0;
        for(int i=0; i<=3; i++){
            ans += findCombination(n,i)*findCombination(m,t-i);
        }
        ans += findCombination(n, t) * findCombination(m, 0);
        System.out.println(nct - ans);
    }
}
