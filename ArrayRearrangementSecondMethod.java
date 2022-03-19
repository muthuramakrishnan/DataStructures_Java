import java.util.Arrays;
import java.util.Scanner;

public class ArrayRearrangementSecondMethod {
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

        for(int i=0; i<n; i++){
            //old value is existing value
            //new value is gonna be the index
            int oldValue = array[i] % n;
            array[oldValue] = n*i + array[oldValue];
        }
        for(int i=0; i<n; i++){
            array[i] = array[i]/n;
        }
        System.out.println(Arrays.toString(array));
    }
}
