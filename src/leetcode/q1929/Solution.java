package leetcode.q1929;

class Solution {

    public int[] getConcatenation(int[] numsInput) {
        int[] ans = new int[numsInput.length * 2];
        for (int i = 0; i < numsInput.length; i++) {
            ans[i] = numsInput[i];
            ans[i + numsInput.length] = numsInput[i];
        }
        return ans;
    }
}

class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numsInput = {1, 2, 1};
        solution.getConcatenation(numsInput);
    }
}
