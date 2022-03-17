import java.util.Scanner;

public class SlidingWindow {
    public static void main(String[] args){
        int n, k;
        //here k is window size
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        k = s.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }

        //find the sum of all sub arrrays of size k
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += array[i];
        }
        int totalSum = 0;
        for(int i=k; i<n; i++){
            //print the result
            totalSum += sum;

            //add the new element
            sum += array[i];
            //remove the 1st element
            sum -= array[i-k];
        }
        totalSum += sum;
        System.out.println(totalSum);
    }
}
