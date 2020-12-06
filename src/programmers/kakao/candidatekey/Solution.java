package programmers.kakao.candidatekey;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;

        List<Set<Integer>> columnIndexesCombinations = new ArrayList<>();
        List<Set<Integer>> minimalityKeys = new ArrayList<>();
        int[] columnIndexes = new int[relation[0].length];
        for (int i = 0; i < relation[0].length; i++) {
            columnIndexes[i] = i;
        }
        for (int r = 1; r <= columnIndexes.length; r++) {
            boolean[] visited = new boolean[columnIndexes.length];
            combinations(columnIndexesCombinations, visited, columnIndexes, 0, columnIndexes.length, r);
        }

        for (Set<Integer> indexes : columnIndexesCombinations) {
            if (!isMinimalKeys(minimalityKeys, indexes)) {
                Set<String> rows = new HashSet<>();
                for (int rowIndex = 0; rowIndex < relation.length; rowIndex++) {
                    StringBuilder builder = new StringBuilder();
                    for (int columnIndex : indexes) {
                        builder.append(relation[rowIndex][columnIndex]);
                    }
                    rows.add(builder.toString());
                }
                if (rows.size() == relation.length) {
                    answer++;
                    minimalityKeys.add(indexes);
                }
            }
        }

        return answer;
    }

    private static boolean isMinimalKeys(List<Set<Integer>> minimalityKeys, Set<Integer> indexes) {
        for (Set<Integer> minimalityKey : minimalityKeys) {
            if (indexes.containsAll(minimalityKey)) {
                return true;
            }
        }
        return false;
    }

    private static void combinations(List<Set<Integer>> result, boolean[] visited, int[] input, int start, int n, int r) {
        if (r == 0) {
            Set<Integer> tmpResult = new HashSet<>();
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    tmpResult.add(input[i]);
                }
            }
            result.add(tmpResult);
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combinations(result, visited, input, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}

class Test {
    public static void main(String[] args) {
        String[][] relation = {
            {"a","b","c"},
            {"1","b","c"},
            {"a","b","4"},
            {"a","5","c"}
        };
        System.out.println(new Solution().solution(relation));
    }
}