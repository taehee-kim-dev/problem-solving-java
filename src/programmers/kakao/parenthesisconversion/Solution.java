package programmers.kakao.parenthesisconversion;

import java.util.Stack;

class Solution {

    private final Stack<String> stack = new Stack<>();

    public String solution(String p) {
        return this.convert(p);
    }

    private String convert(String s){
        if (s.isEmpty()){
            return "";
        }

        int i = 1;
        String u = null;
        String v = null;
        while (i <= s.length()){
            u = s.substring(0, i);
            v = s.substring(i);
            if (this.isBalancedParentheses(u)){
                break;
            }
            i += 1;
        }

        if (this.isRightParentheses(u)){
            return u + this.convert(v);
        }else{
            String ret = "(";
            ret += this.convert(v);
            ret += ')';
            u = u.substring(1, u.length() - 1);
            u = this.reverseParentheses(u);
            ret += u;
            return ret;
        }
    }

    private String reverseParentheses(String u) {
        String result = "";
        for (int i = 0; i < u.length(); i++){
            if (u.charAt(i) == '('){
                result += ')';
            }else{
                result += '(';
            }
        }
        return result;
    }

    private boolean isBalancedParentheses(String s){
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                left += 1;
            }else{
                right += 1;
            }
        }
        return left == right;
    }

    private boolean isRightParentheses(String s){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                this.stack.push("(");
            }else{
                if (stack.isEmpty()){
                    return false;
                }else if (stack.peek().equals("(")){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}

class Test{

    public static void main(String[] args) {

        String p = ")(";
        System.out.println(new Solution().solution(p));
    }
}