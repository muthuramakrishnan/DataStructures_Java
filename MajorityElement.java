import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {
    public static void mooreVotingAlgorithm(int[] array, int n){
        int element = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            if(count==0){
                element = array[i];
            }
            //whenever we find some other element which is not equal to the current element
            //then decrease the count
            if(element == array[i]){
                count++;
            }
            else count--;
        }
        System.out.println(element);
    }
    public static void hashMapApproach(int[] array, int n){
        //this uses o(n) extra space
        //o(n) / O(nlogn) complexity
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!m.containsKey(array[i])){
                m.put(array[i], 1);
            }
            else{
                int value = m.get(array[i])+1;
                if (value > array.length /2) {
                    System.out.println(array[i]);
                    return;
                }
                else{
                    m.put(array[i], value);
                }
            }
        }
    }
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

//        hashMapApproach(array, n);
        mooreVotingAlgorithm(array, n);
    }
}
