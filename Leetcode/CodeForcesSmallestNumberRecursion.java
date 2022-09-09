package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeForcesSmallestNumberRecursion {
    public static int findSmallestResult(int[] arr, char[] operators, int tempResult, int index) {
        if (index > 2) {
            return tempResult;
        }
        int res = Integer.MAX_VALUE;
        if (tempResult < 0) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] != -1) {
                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[j] != -1) {
                            int temp = operators[index] == '*' ? arr[i] * arr[j] : arr[i] + arr[j];
                            arr[i] = arr[j] = -1;
                            res = Math.min(findSmallestResult(arr, operators, temp, index + 1), res);
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != -1) {
                    int temp = operators[index] == '*' ? arr[i] * tempResult : arr[i] + tempResult;
                    arr[i] = -1;
                    res = Math.min(findSmallestResult(arr, operators, temp, index + 1), res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int[] arr = new int[4];
        char[] operators = new char[3];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            operators[i] = str.nextToken().charAt(0);
        }

        int tempResult = -1;
        int index = 0;
        System.out.println(findSmallestResult(arr, operators, tempResult, index));

    }
}
