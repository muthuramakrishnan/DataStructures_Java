import java.util.Scanner;

public class MaximumChunks {
    public static void main(String[] args){
        //given some elements
        //where the elements are permutation of 0 - n-1
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int[] array = new int[n];
        int maxElement = Integer.MIN_VALUE;
        int chunks = 0;
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
            maxElement = Math.max(maxElement, array[i]);
            if(maxElement == i){
                chunks++;
            }
        }
        System.out.println(chunks);
    }
}
