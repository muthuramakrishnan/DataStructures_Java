package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LexicographicSubsets {
    public static void printSubsets(int[] auxArr, int auxArrSize, int[] arr, int index) {
        for(int i=0; i<auxArrSize; i++){
            System.out.print(auxArr[i]);
        }
        System.out.println();
        if(index==arr.length){
            return;
        }
        for(int i=index; i<arr.length; i++){
            auxArr[auxArrSize] = arr[i];
            printSubsets(auxArr, auxArrSize+1, arr, i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        //I have to print the subsets in lexicographic order so make recursive calls in such a way
        int[] auxArr = new int[n];
        int auxArrSize = 0, index = 0;
        printSubsets(auxArr, auxArrSize, arr, index);
    }
}
