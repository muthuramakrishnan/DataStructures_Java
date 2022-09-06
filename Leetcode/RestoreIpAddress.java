package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestoreIpAddress {
    public static void buildIpAddresses(int index, int dots, String inputStr, char[] auxCharArr, List<String> output) {
        if (dots > 3) {
            if (index >= inputStr.length()) {
                output.add(String.copyValueOf(auxCharArr, 0, index + dots - 1));
            }
            return;
        }
        if (index >= inputStr.length()) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (i + index >= inputStr.length()) {
                return;
            }
            int tempNo = Integer.parseInt(inputStr.substring(index, i + index + 1));
            if ((i > 0 && inputStr.charAt(index) == '0') || tempNo > 255) {
                return;
            }
            auxCharArr[i + index + dots] = inputStr.charAt(i + index);
            auxCharArr[i + index + dots + 1] = '.';
            buildIpAddresses(i + index + 1, dots + 1, inputStr, auxCharArr, output);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int n = str.length();
        if (n > 12 || n < 4) {
            System.out.println(new ArrayList<>() {
            });
        }

        final int ipMaxLength = 16;
        char[] auxCharArr = new char[ipMaxLength];
        List<String> output = new ArrayList<>();
        int index = 0, dots = 0;
        buildIpAddresses(index, dots, str, auxCharArr, output);
        System.out.println(output);
    }
}
