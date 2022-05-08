package Leetcode;

import java.util.*;

public class ContiguousSubArray523 {
    public static void main(String args[]){
        int n, k;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        k = s.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
        remainderIndexMap.put(0, -1);
        int sum = 0;
        for(int i=0; i<n; i++){
            sum = (sum + array[i])%k;
            int value = -1;
            if(remainderIndexMap.containsKey(sum)){
                value = remainderIndexMap.get(sum);
                value = i - value;
            }
            else {
                remainderIndexMap.put(sum, i);
            }

            if(value>=0){
                System.out.println(true);
            }
        }
        System.out.println(false);
    }
}
