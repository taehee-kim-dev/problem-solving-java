package LeetCode.q22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recursive(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void recursive(int n, int left, int right, StringBuilder sb, List<String> result) {
        if (left == n && right == n) {
            result.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            recursive(n, left + 1, right, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (left > right) {
            sb.append(")");
            recursive(n, left, right + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}