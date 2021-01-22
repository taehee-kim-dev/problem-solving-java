package LeetCode.q1704;

import java.util.Set;

class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            count += vowels.contains(s.charAt(left)) ? 1 : 0;
            count += vowels.contains(s.charAt(right)) ? -1 : 0;
        }
        return count == 0;
    }
}

class Test {
    public static void main(String[] args) {
        String s = "book";
        System.out.println(new Solution().halvesAreAlike(s));
    }
}