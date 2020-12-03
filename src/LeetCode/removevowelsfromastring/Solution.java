package LeetCode.removevowelsfromastring;

class Solution {
    public String removeVowels(String S) {
        return S.replaceAll("[aeiou]", "");
    }
}
