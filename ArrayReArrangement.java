import java.util.Scanner;

public class ArrayReArrangement {
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

        for(int i=0; i<n; i++){
            if(array[i]>=0){
                int index = array[i];
                int value = i;
                while(index != i){
                    int temp = array[index];
                    array[index] = -(value + 1);
                    value = index;
                    index = temp;
                }
                array[index] = -(value + 1);
            }
        }
        for(int i=0; i<n; i++){
            System.out.print(-array[i]-1 +" ");
        }
    }
}
