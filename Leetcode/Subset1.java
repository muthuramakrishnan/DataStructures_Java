package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Subset1 {
    public static int findCountOfSubsetsWithSum(int[] arr, int[] auxArr, int index, int auxArrIndex, int k) {
        if (index == arr.length) {
            int sum = 0;
            for (int i = 0; i < auxArrIndex; i++) {
                sum += auxArr[i];
            }
            return sum == k ? 1 : 0;
        }

        //you have 2 choices
        int result = findCountOfSubsetsWithSum(arr, auxArr, index + 1, auxArrIndex, k);
        auxArr[auxArrIndex] = arr[index];

        result += findCountOfSubsetsWithSum(arr, auxArr, index + 1, auxArrIndex + 1, k);
        return result;
    }

    public static void main(String[] args) throws IOException {
        int n, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        int[] auxArr = new int[n];
        int index = 0, auxArrIdx = 0;
        System.out.println(findCountOfSubsetsWithSum(arr, auxArr, index, auxArrIdx, k));
    }
}
