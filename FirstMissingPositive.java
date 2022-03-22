import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstMissingPositive {
    public static void optimizedAlgo2(int[] array){
        //use the same array as a set instead of declaring a new set
        int n = array.length;
        for(int i=0; i<n; i++){
            if(array[i]<=0){
                array[i] = n+1;
            }
        }
        for(int i=0; i<n; i++){
            //first handle out of bounds
            //there can be values greater than n
            //there can be negative values
                int index = Math.abs(array[i]);
                //why index-1?
                //our array is 0 to N-1
                //but solution lies between 1 to N.  To convert 0 based to 1 based indexing for set
                if(index<=n && index-1>=0){
                    //there can be numbers which are already negative - > when there's a repetition in the original array
                    //we don't want to change them to positive again
                    if(array[index-1]>0){
                        array[index-1] = -array[index-1];
                    }
                }
        }
        for(int i=0; i<n; i++){
            if(array[i]>0){
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(n+1);
    }
    public static void optimizedAlgo1(int[] array){
        //Your solution needs to lie bwn 1 to length of array + 1
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<array.length; i++){
            s.add(array[i]);
        }
        for(int i=1; i<=array.length; i++){
            if(!s.contains(i)){
                System.out.println(i);
                return;
            }
        }
        System.out.println(array.length);
    }
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

//        optimizedAlgo1(array);
        optimizedAlgo2(array);
    }
}
