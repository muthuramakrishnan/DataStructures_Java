import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeNumberSum {
    public static List<Integer[]> findThreeNumberSum(int[] array, int targetSum){
        int n = array.length;
        List<Integer[]> result = new ArrayList<>(n);
        for(int i=0; i<n-2; i++){
            int l = i+1;
            int r = n-1;
            //why less than r
            //because numbers cannot repeat
            while(l<r){
                int currentSum = array[i] + array[l] + array[r];
                if(currentSum == targetSum){
                    result.add(new Integer[] {array[i], array[l], array[r]});
                    //do not break out here
                    //because i need all the triplets not only one
//                    break;
                    l++;
                    r--;
                }
                else if(currentSum < targetSum){
                    l++;
                }
                else r--;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int n, targetSum;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        targetSum = s.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }
        Arrays.sort(array);
        List<Integer[]> resultList= findThreeNumberSum(array, targetSum);
        for(Integer[] resultItem : resultList){
            System.out.println(Arrays.toString(resultItem));
        }
    }
}
