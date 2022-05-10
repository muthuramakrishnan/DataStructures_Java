package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContiguousArray525 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n;
        n = s.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

        Map<Integer, Integer> m = new HashMap<>();
        int total = array[0] == 1 ? 1 : -1;
        int maxLength = 0;
        m.put(total, 1);

        for(int i=1; i<n; i++){
            if(array[i]==1){
                total += array[i];
            }
            else {
                total--;
            }

            if(m.containsKey(total)){
                maxLength = Math.max(maxLength, m.get(total) - (i+1));
            }
            else if(total == 0){
                maxLength = (i+1);
            }
        }
        System.out.println(maxLength);
    }
}
