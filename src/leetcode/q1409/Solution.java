package leetcode.q1409;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] answer = new int[queries.length];
        List<Integer> P = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            P.add(i);
        }

        for (int i = 0; i < queries.length; i++) {
            int position = P.indexOf(queries[i]);
            answer[i] = position;
            P.remove(position);
            P.add(0, queries[i]);
        }
        return answer;
    }
}