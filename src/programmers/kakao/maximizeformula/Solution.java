package programmers.kakao.maximizeformula;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class Solution {

    private final ArrayList<char[]> cases = new ArrayList<>() {
        {
            add(new char[]{'+', '-', '*'});
            add(new char[]{'+', '*', '-'});
            add(new char[]{'*', '+', '-'});
            add(new char[]{'*', '-', '+'});
            add(new char[]{'-', '+', '*'});
            add(new char[]{'-', '*', '+'});
        }
    };

    public long solution(String expression) {
        long answer = 0;

        ArrayList<String> splitStr = this.getSplitStr(expression);

        for (char[] oneCase : this.cases) {
            answer = Math.max(answer, Math.abs(this.getResult(oneCase, splitStr)));
        }

        return answer;
    }

    private long getResult(char[] oneCase, ArrayList<String> splitStr) {
        Deque<String> before = new ArrayDeque<>();
        Deque<String> after = new ArrayDeque<>();
        for (String s : splitStr) {
            after.addLast(s);
        }
        for (char operator : oneCase) {
            before = new ArrayDeque<>(after);
            after.clear();
            while (!before.isEmpty()) {
                String curValue = before.pollFirst();
                if (curValue.equals(String.valueOf(operator))) {
                    String beforeNum = after.pollLast();
                    String afterNum = before.pollFirst();
                    switch (operator) {
                        case '+':
                            after.addLast(String
                                .valueOf(Long.parseLong(beforeNum) + Long.parseLong(afterNum)));
                            break;
                        case '-':
                            after.addLast(String
                                .valueOf(Long.parseLong(beforeNum) - Long.parseLong(afterNum)));
                            break;
                        case '*':
                            after.addLast(String
                                .valueOf(Long.parseLong(beforeNum) * Long.parseLong(afterNum)));
                            break;
                    }
                } else {
                    after.addLast(curValue);
                }
            }
        }
        return after.stream().mapToLong(Long::parseLong).sum();
    }

    private ArrayList<String> getSplitStr(String expression) {
        ArrayList<String> splitStr = new ArrayList<>();
        String numPart = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' ||
                expression.charAt(i) == '-' ||
                expression.charAt(i) == '*') {
                splitStr.add(numPart);
                splitStr.add(String.valueOf(expression.charAt(i)));
                numPart = "";
            } else {
                numPart += expression.charAt(i);
            }
        }
        splitStr.add(numPart);
        return splitStr;
    }
}

class Test {

    public static void main(String[] args) {
        String[] expressions = {"100-200*300-500+20", "50*6-3*2"};
        for (String expression : expressions) {
            System.out.println(new Solution().solution(expression));
        }
        /*
         *  60420
         *  300
         */
    }
}