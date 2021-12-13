package leetcode.q1329;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, PriorityQueue<Integer>> numbersOfDiagonal = new HashMap<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                numbersOfDiagonal.putIfAbsent(row - col, new PriorityQueue<>());
                numbersOfDiagonal.get(row - col).add(mat[row][col]);
            }
        }

        for(int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                mat[row][col] = numbersOfDiagonal.get(row - col).poll();
            }
        }
        return mat;
    }
}