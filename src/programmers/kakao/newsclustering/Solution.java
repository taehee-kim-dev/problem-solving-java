package programmers.kakao.newsclustering;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {

        Map<String, Integer> countStr1 = new HashMap<>();
        Map<String, Integer> countStr2 = new HashMap<>();
        Map<String, Integer> intersection = new HashMap<>();
        Map<String, Integer> union = new HashMap<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        countParts(str1, countStr1);
        countParts(str2, countStr2);

        getIntersection(intersection, countStr1, countStr2);
        getUnion(union, countStr1, countStr2);

        int intersectionSize = getIntersectionSize(intersection);
        int unionSize = getUnionSize(union);

        if (unionSize == 0) {
            return 65536;
        }

        double result = (double)intersectionSize / (double)unionSize;
        result *= 65536.0;
        return (int)result;
    }

    private int getUnionSize(Map<String, Integer> union) {
        int result = 0;
        for (String key : union.keySet()) {
            result += union.get(key);
        }
        return result;
    }

    private int getIntersectionSize(Map<String, Integer> intersection) {
        int result = 0;
        for (String key : intersection.keySet()) {
            result += intersection.get(key);
        }
        return result;
    }

    private void getUnion(Map<String, Integer> union, Map<String, Integer> countStr1,
        Map<String, Integer> countStr2) {

        Set<String> str1Keys = new HashSet<>(countStr1.keySet());
        Set<String> str2Keys = new HashSet<>(countStr2.keySet());
        str1Keys.addAll(str2Keys);
        for (String key : str1Keys) {
            if (!countStr1.containsKey(key) && countStr2.containsKey(key)) {
                union.put(key, countStr2.get(key));
                continue;
            }
            if (countStr1.containsKey(key) && !countStr2.containsKey(key)) {
                union.put(key, countStr1.get(key));
                continue;
            }
            if (countStr1.containsKey(key) && countStr2.containsKey(key)) {
                union.put(key, Math.max(countStr1.get(key), countStr2.get(key)));
            }
        }
    }

    private void getIntersection(Map<String, Integer> intersection, Map<String, Integer> countStr1,
        Map<String, Integer> countStr2) {

        Set<String> str1Keys = new HashSet<>(countStr1.keySet());
        Set<String> str2Keys = new HashSet<>(countStr2.keySet());
        str1Keys.retainAll(str2Keys);
        for (String key : str1Keys) {
            intersection.put(key, Math.min(countStr1.get(key), countStr2.get(key)));
        }
    }

    private void countParts(String str, Map<String, Integer> countStr1) {
        for (int i = 0; i < str.length() - 1; i++) {
            String str1Part = str.substring(i, i + 2);
            boolean isPartContained = countStr1.containsKey(str1Part);
            String allowedPattern = "^[a-z]+$";
            if (!Pattern.matches(allowedPattern, str1Part)) {
                continue;
            }
            if (isPartContained) {
                int count = countStr1.get(str1Part);
                countStr1.put(str1Part, count + 1);
            }
            if (!isPartContained) {
                countStr1.put(str1Part, 1);
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        Solution solution = new Solution();
        System.out.println(solution.solution(str1, str2));
    }
}