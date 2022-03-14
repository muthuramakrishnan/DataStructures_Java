import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class TwoNumberSum {

    public static int[] hashingApproach(int[] array, int target){
        //O(n) - Time complexity
        //O(n) - space complexity
        Set s = new HashSet();

        for(int i=0; i<array.length; i++){
            int num = target - array[i];
            if(s.contains(num)){
                return new int[] {num, array[i]};
            }
            else {
                s.add(array[i]);
            }
        }
        return new int[] {};
    }
    public static int[] bruteForceTwoNumberSum(int[] array, int target){
//        o(n2)
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if(array[i] + array[j] == target){
                    return new int[] {array[i], array[j]};
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args){
        int n, target;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        target = s.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

        int[] result;
//        result = bruteForceTwoNumberSum(array, target);
        result = hashingApproach(array, target);
        if(result.length == 0){
            System.out.println("No such numbers");
        }
        for(int item : result){
            System.out.print(item+" ");
        }
    }
}
