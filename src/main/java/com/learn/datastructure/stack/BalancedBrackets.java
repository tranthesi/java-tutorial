package com.learn.datastructure.stack;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println(isBalances("{[()]}"));
    }

    static boolean isBalances(String input) {
        char[] arr = input.toCharArray();
        Stack<Character> stack = new Stack();

        for(char c: arr) {
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (!isMatch(top, c)) {
                    return false;
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }

    static boolean isMatch(char c1, char c2) {
        if(c1 == '{' && c2 == '}') {
            return true;
        } else if (c1 == '[' && c2 == ']') {
            return true;
        } else if (c1 == '(' && c2 == ')') {
            return true;
        }
        return false;
    }
}
