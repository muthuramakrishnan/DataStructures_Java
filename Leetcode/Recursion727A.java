package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Recursion727A {
    public static boolean getPathOfTransformation(int a, int b, List<Integer> outputList) {
        if (a == b) {
            return true;
        } else if (b % 2 != 0 && b % 10 != 1 || b < 1) {
            return false;
        }
        int newB = b % 10 == 1 ? b / 10 : b / 2;
        outputList.add(newB);
        return getPathOfTransformation(a, newB, outputList);
    }

    public static void main(String[] args) throws IOException {
        int a, b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        a = Integer.parseInt(str.nextToken());
        b = Integer.parseInt(str.nextToken());

        List<Integer> outputList = new ArrayList<>();
        outputList.add(b);
        boolean isPossible = getPathOfTransformation(a, b, outputList);
        System.out.println(isPossible ? "YES" : "NO");
        if (isPossible) {
            System.out.println(outputList.size());
            //iterator start position
            ListIterator li = outputList.listIterator(outputList.size());
            while (li.hasPrevious()) {
                System.out.print((Integer) li.previous() + " ");
            }
        }
    }
}
