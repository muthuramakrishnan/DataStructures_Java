package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecursionKeypad {
    final static Map<Integer, List<Character>> digitMap = new HashMap<>();
    public static void printAllCombos(String temp, String digits, int index){
        System.out.println(temp);
        if(index+1>digits.length()){
            return;
        }
        List<Character> charList = digitMap.get(digits.charAt(index) - '0');
        for(char c : charList){
            printAllCombos(temp + c, digits, index+1);
        }
    }
    public static void main(String[] args)throws IOException {
        char currChar = 'a';
        for (int i = 2; i <= 9; i++) {
            List<Character> charList = new ArrayList<>();
            if (i == 7 || i == 9) {
                for(int j=0; j<4; j++){
                    charList.add(currChar++);
                }
            } else {
                for(int j=0; j<3; j++){
                    charList.add(currChar++);
                }
            }
            digitMap.put(i, charList);
        }
//        for (Map.Entry<Integer, List<Character>> entryItem : digitMap.entrySet()) {
//            System.out.println(entryItem.getKey() + " " + entryItem.getValue());
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String digits = br.readLine();
        printAllCombos(new String(""), digits, 0);
    }
}
