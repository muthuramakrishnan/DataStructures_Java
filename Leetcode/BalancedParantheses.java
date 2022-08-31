package Leetcode;

import java.util.Scanner;

public class BalancedParantheses {
    public static void printParanthesis(char[] paranthesisStr, int openCount, int closeCount, int index, int n) {
        if(index == 2*n){
            for (int i = 0; i < index; i++) {
                System.out.print(paranthesisStr[i]);
            }
            System.out.println();
            return;
        }

        if(openCount == closeCount){
            paranthesisStr[index] = '(';
            printParanthesis(paranthesisStr, openCount+1, closeCount, index+1, n);
        }
        else if(openCount > closeCount){
            if(openCount == n){
                //1. opening braces are over
                paranthesisStr[index] = ')';
                printParanthesis(paranthesisStr, openCount, closeCount+1, index+1, n);
            }
            else{
                //1. I have 2 choices -> Either go with opening brace
                //2. or go with closing brace
                paranthesisStr[index] = '(';
                printParanthesis(paranthesisStr, openCount+1, closeCount, index+1, n);

                paranthesisStr[index] = ')';
                printParanthesis(paranthesisStr, openCount, closeCount+1, index+1, n);
            }
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        char[] paranthesisStr = new char[2 * n + 1];
        printParanthesis(paranthesisStr, 0, 0, 0, n);
    }
}
