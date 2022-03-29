import java.util.Arrays;
import java.util.Scanner;

public class MoveElementToEnd {
    public static void main(String[] args) {
        int n, k;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        k = s.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = s.nextInt();
        }

        int i=0;
        int j=n-1;
        while(i<j){
            if(array[j] != k && array[i]==k){
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;
                j--;
            }
            else if(array[j]==k){
                j--;
            }
            else if(array[i]!=k){
                i++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
