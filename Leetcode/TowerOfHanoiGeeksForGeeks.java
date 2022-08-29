//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int n = Integer.parseInt(a[1]);

            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.shiftPile(N, n);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void solveTowerOfHanoi(int N, int n, int a, int b, int c, List<List<Integer>> result){
        if(N==1){
            List<Integer> tempList = new ArrayList<>(2);
            tempList.add(a);
            tempList.add(c);
            result.add(tempList);
            return;
        }
        solveTowerOfHanoi(N - 1, n, a, c, b, result);
        List<Integer> tempList = new ArrayList<>(2);
        tempList.add(a);
        tempList.add(c);
        result.add(tempList);
        solveTowerOfHanoi(N - 1, n, b, a, c, result);

    }
    static List<Integer> shiftPile(int N, int n){
        // code here
        List<List<Integer>> result = new ArrayList<>();
        int move = 0;
        solveTowerOfHanoi(N,n, 1, 2, 3, result);
        return n>=result.size() ? new ArrayList<>() {} : result.get(n-1);
    }
}