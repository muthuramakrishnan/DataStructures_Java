package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AllSubSetsRecursion {
    public static void printAllSubSet(int[] temp, int[] arr, int index, int size) {
        if(arr.length == index){
            //These are leaf nodes - so print them
            for(int i=0; i<size; i++){
                System.out.print(temp[i]);
            }
            System.out.println();
            return;
        }
        int digit = arr[index];
        //Recurrence call 1 -> without including the digit
        printAllSubSet(temp, arr, index+1, size);

        //Recurrence call 2 -> Include the digit
        temp[size] = digit;
        printAllSubSet(temp, arr, index+1, size+1);
    }

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        int[] temp = new int[n];
        Arrays.fill(temp, -1);
        printAllSubSet(temp, arr, 0, 0);
    }
}
