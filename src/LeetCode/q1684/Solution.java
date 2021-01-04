package LeetCode.q1684;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<String> allowedChars = getAllowedCharsSet(allowed);
        int answer = 0;
        for (String word : words) {
            if (isConsistentString(allowedChars, word)) {
                answer += 1;
            }
        }
        return answer;
    }

    private boolean isConsistentString(Set<String> allowedChars, String word) {
        Set<String> wordDuplicateRemoved = Arrays.stream(word.split("")).collect(Collectors.toSet());
        return allowedChars.containsAll(wordDuplicateRemoved);
    }

    private Set<String> getAllowedCharsSet(String allowed) {
        return Arrays.stream(allowed.split("")).collect(Collectors.toSet());
    }
}