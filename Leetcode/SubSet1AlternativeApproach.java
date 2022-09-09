package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSet1AlternativeApproach {
    public static int findCountOfSubsetsWithSum(int[] arr, int index, int k, int sum) {
        if (index == arr.length) {
            return sum == k ? 1 : 0;
        }

        //you have 2 choices
        int result = findCountOfSubsetsWithSum(arr, index + 1, k, sum);

        sum += arr[index];
        result += findCountOfSubsetsWithSum(arr, index + 1, k, sum);
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

        int index = 0, sum = 0;
        System.out.println(findCountOfSubsetsWithSum(arr, index, k, sum));
    }
}
