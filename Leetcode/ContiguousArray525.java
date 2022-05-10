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

            //edge case 1
            if(m.containsKey(total) & total!=0){
                maxLength = Math.max(maxLength, (i+1)-m.get(total));
            }
            //edge case 2
            else if(total == 0){
                maxLength = (i+1);
                m.put(total, i+1);
            }
            else{
                //dont forget to update the map
                m.put(total, i+1);
            }
        }
        System.out.println(maxLength);
    }
}
