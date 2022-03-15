import java.util.Scanner;

public class RotateArray {
    public static void rotateArrayOneUnit(int[] array){
        int temp = array[array.length-1];
        for(int i=array.length-2; i>=0; i--){
            array[i+1] = array[i];
        }
        array[0] = temp;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n;
        n = s.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }
        rotateArrayOneUnit(array);
        for(int item : array){
            System.out.print(item + " ");
        }
    }
}
