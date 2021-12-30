package leetcode.q2114;

class Solution {

    public int mostWordsFound(String[] sentences) {
        int maxNumberOfWords = 0;

        for (String sentence : sentences) {
            String[] words = sentence.split(" ");
            maxNumberOfWords = Math.max(maxNumberOfWords, words.length);
        }

        return maxNumberOfWords;
    }
}

class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        solution.mostWordsFound(sentences);
    }
}
