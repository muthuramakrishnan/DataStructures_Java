package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecurrsionKeyPadOptimized {
    final static Map<Integer, List<Character>> digitMap = new HashMap<>();

    public static void printLetterCombos(char[] temp, String ipKeyCombo, int index) {
        System.out.println();
        for (int i = 1; i < index + 1; i++) {
            System.out.print(temp[i]);
        }
        if (index + 1 > ipKeyCombo.length()) {
            return;
        } else {
            List<Character> charList = digitMap.get(ipKeyCombo.charAt(index) - '0');
            for (char c : charList) {
                temp[index + 1] = c;
                printLetterCombos(temp, ipKeyCombo, index + 1);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        char c = 'a';
        for (int i = 2; i <= 9; i++) {
            List<Character> charList = new ArrayList<>();
            for (int j = 0; (i == 7 || i == 9) ? j < 4 : j < 3; j++) {
                charList.add(c++);
            }
            digitMap.put(i, charList);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ipKeyCombo = br.readLine();
        char[] temp = new char[ipKeyCombo.length() + 1];
        printLetterCombos(temp, ipKeyCombo, 0);
    }
}
