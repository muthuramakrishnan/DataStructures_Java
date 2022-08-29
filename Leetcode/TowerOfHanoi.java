package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TowerOfHanoi {
    public static void solveTowerOfHanoi(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("Move 1st disk from " + a + " to " + c);
            return;
        }
        solveTowerOfHanoi(n - 1, a, c, b);
        System.out.println("Move " + (n) + "th disk from " + a + " to " + c);
        solveTowerOfHanoi(n - 1, b, a, c);

    }

    public static void main(String[] args) throws IOException {
        int n;
        char a, b, c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        a = str.nextToken().charAt(0);
        b = str.nextToken().charAt(0);
        c = str.nextToken().charAt(0);

        solveTowerOfHanoi(n, a, b, c);
//        System.out.println(steps);
    }
}
