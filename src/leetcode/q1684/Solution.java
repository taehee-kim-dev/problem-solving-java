package leetcode.q1684;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedChars = getAllowedCharsSet(allowed);
        int answer = 0;
        for (String word : words) {
            if (isConsistentString(allowedChars, word)) {
                answer += 1;
            }
        }
        return answer;
    }

    private boolean isConsistentString(Set<Character> allowedChars, String word) {
        Set<Character> wordSet = getWordSet(word);
        return allowedChars.containsAll(wordSet);
    }

    private Set<Character> getWordSet(String word) {
        Set<Character> wordSet = new HashSet<>();
        for (char charInWord : word.toCharArray()) {
            wordSet.add(charInWord);
        }
        return wordSet;
    }

    private Set<Character> getAllowedCharsSet(String allowed) {
        Set<Character> allowedCharsSet = new HashSet<>();
        for (char allowedChar : allowed.toCharArray()) {
            allowedCharsSet.add(allowedChar);
        }
        return allowedCharsSet;
    }
}