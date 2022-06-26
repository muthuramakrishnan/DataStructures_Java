package Leetcode;

import java.util.Scanner;

public class PermutationInString {
    public static boolean isAnagram(int[] freqArr1, int[] freqArr2){
        for(int i=0; i<26; i++){
            if(freqArr1[i] != freqArr2[i]){
                return false;
            }
        }
        return true;
    }
    public static boolean checkInclusion(String s1, String s2) {
        int[] freqArr1 = new int[26];
        int[] freqArr2 = new int[26];
        int windowSize = s1.length();
        int m = s2.length();
        if(windowSize > m){
            return false;
        }
        for(int i=0; i<26; i++){
            freqArr1[i] = 0;
            freqArr2[i] = 0;
        }
        for(int i=0; i<windowSize; i++){
            freqArr1[s1.charAt(i) - 'a']++;
        }
        for(int i=0; i<windowSize; i++){
            freqArr2[s2.charAt(i)-'a']++;
        }
        for(int i=windowSize; i<m; i++){
            if(isAnagram(freqArr1, freqArr2)){
                return true;
            }
            freqArr2[s2.charAt(i-windowSize)-'a']--;
            freqArr2[s2.charAt(i)-'a']++;
        }
        return isAnagram(freqArr1, freqArr2);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String s1, s2;
        s1 = s.next();
        s2 = s.next();
        System.out.println(checkInclusion(s1, s2));
    }
}
