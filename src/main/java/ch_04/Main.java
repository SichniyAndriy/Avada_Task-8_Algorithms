package ch_04;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введіть формулу: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("Формула " + (isValid(line) ? "валідна" : "не валідна"));
    }

    private static boolean isValid(String line) {
        Stack<Character> stack = new Stack<>();
        for (char ch : line.toCharArray()) {
            try {
                switch (ch) {
                    case '(', '{', '[', '<' -> stack.push(ch);
                    case ')' -> {
                        if (stack.peek() != '(') return false;
                        else stack.pop();
                    }
                    case '}' -> {
                        if (stack.peek() != '{') return false;
                        else stack.pop();
                    }
                    case ']' -> {
                        if (stack.peek() != ']') return false;
                        else stack.pop();
                    }
                    case '>' -> {
                        if (stack.peek() != '<') return false;
                        else stack.pop();
                    }
                }
            } catch (EmptyStackException e) {
                return false;
            }
        }
        return stack.empty();
    }
}
