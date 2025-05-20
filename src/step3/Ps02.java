package step3;

import java.util.Stack;

public class Ps02 {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (Character currentChar : s.toCharArray()) {
            if (currentChar == ')') {
                StringBuilder innerString = new StringBuilder();

                while (!stack.empty()) {
                    String topChar = stack.pop();

                    if (topChar.equals("(")) {
                        StringBuilder repeatCount = new StringBuilder();

                        // 숫자형 문자를 읽어옴
                        while (!stack.empty() && Character.isDigit(stack.peek().charAt(0))) {
                            repeatCount.insert(0, stack.pop());
                        }

                        // 반복 횟수를 설정, 없으면 1로 설정
                        int count = repeatCount.toString().isEmpty() ? 1 : Integer.parseInt(repeatCount.toString());

                        // 결과를 스택에 넣어줌
                        stack.push(innerString.toString().repeat(count));
                        break;
                    }
                    // 괄호 안의 문자열을 이어 붙임
                    innerString.insert(0, topChar);
                }
            } else {
                // 닫는 괄호가 아니라면 스택에 문자 추가
                stack.push(String.valueOf(currentChar));
            }
        }

        // 남아 있는 문자열 붙이기
        for (String str : stack) {
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Ps02 T = new Ps02();

        System.out.println(T.solution("3(a2(b))ef")); // "abbabbabbef"
        System.out.println(T.solution("2(ab)k3(bc)")); // "ababkbcbcbc"
        System.out.println(T.solution("2(ab3((cd)))")); // "abcdcdcdabcdcdcd"
        System.out.println(T.solution("2(2(ab)3(2(ac)))")); // "ababacacacacacacababacacacacacac"
        System.out.println(T.solution("3(ab2(sg))")); // "absgsgabsgsgabsgsg"
    }
}
