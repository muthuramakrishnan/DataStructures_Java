import java.util.Scanner;

public class RotateArray {
    public static void reverseArray(int[] array, int start, int end){
        while (start < end)
        {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotateArrayByReversal(int[] array, int k){
        reverseArray(array, 0, array.length-1);
        reverseArray(array, 0, k-1);
        reverseArray(array, k, array.length-1);
    }
    public static int[] rotateArrayOptimized(int[] array, int k){
        //this will have o(n) time complexity
        //o(n) space complexity
        int n = array.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = array[(i+k)%n];
        }
        return result;
    }
    public static void rotateArrayOneUnit(int[] array){
        int temp = array[array.length-1];
        for(int i=array.length-2; i>=0; i--){
            array[i+1] = array[i];
        }
        array[0] = temp;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n, k;
        n = s.nextInt();
        k=s.nextInt();
        k = k%n;

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }
        //brute force way of rotating n units
//        for(int i=0; i<k; i++)
//        rotateArrayOneUnit(array);
//        int[] rotatedArray = rotateArrayOptimized(array, k);
        rotateArrayByReversal(array, k);
        for(int item : array){
            System.out.print(item + " ");
        }
    }
}
