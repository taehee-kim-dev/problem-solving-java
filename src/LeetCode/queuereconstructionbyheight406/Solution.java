package LeetCode.queuereconstructionbyheight406;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return -Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });
        List<int[]> result = new LinkedList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[result.size()][]);
    }
}


class Test {
    public static void main(String[] args) {
        int[][] input = {{9,0},{7,0},{1,9},{3,0}, {2,7}, {5,3}, {6,0}, {3,4}, {6,2}, {5,2}};
        System.out.println(Arrays.deepToString(new Solution().reconstructQueue(input)));
    }
}