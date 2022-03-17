import java.util.Scanner;

public class SlidingWindow_PrintFrequency {
    public static void main(String[] args){
        int n, k, x;
        //here k is window size
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        k = s.nextInt();
        x = s.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = s.nextInt();
        }
        int freq = 0;
        for(int i=0; i<k; i++){
            if(array[i] == x){
                freq++;
            }
        }
        for(int i=k; i<n; i++){
            //output
            System.out.println(freq);

            //add new one
            if(array[i] == x){
                freq++;
            }
            if(array[i-k] == x){
                freq--;
            }
        }
        System.out.println(freq);
    }
}
