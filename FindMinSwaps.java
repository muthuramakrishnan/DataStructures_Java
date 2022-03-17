import java.util.Scanner;

public class FindMinSwaps {
    public static void main(String[] args){
        //find min no of swaps required to bring the elements less than or k together
        int n, k;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        k = s.nextInt();

        int[] array = new int[n];
        int windowSize = 0;
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
            if(array[i]<=k){
                windowSize++;
            }
        }

        int currentCount=0;
        for(int i=0; i<windowSize; i++){
            if(array[i]<=k){
                currentCount++;
            }
        }

        int totalElementsTogether = 0;
        for(int i=k; i<n; i++){
            //print the result
            totalElementsTogether = Math.max(totalElementsTogether, currentCount);

            //add new value
            if(array[i]<=k){
                currentCount++;
            }
            if(array[i-k]<=k){
                currentCount--;
            }
        }
        totalElementsTogether = Math.max(totalElementsTogether, currentCount);
        System.out.println(windowSize - totalElementsTogether);
    }
}
