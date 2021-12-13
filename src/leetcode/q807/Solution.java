package leetcode.q807;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        List<Integer> topOrBottomSkyLine = getTopOrBottomSkyLine(grid);
        List<Integer> leftOrRightSkyLine = getLeftOrRightSkyLine(grid);
        return getMaxTotalSumOfIncreasedHeights(grid, topOrBottomSkyLine, leftOrRightSkyLine);
    }

    private int getMaxTotalSumOfIncreasedHeights(int[][] grid, List<Integer> topOrBottomSkyLine,
        List<Integer> leftOrRightSkyLine) {
        int maxTotalSumOfIncreasedHeights = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                int maxHeight = Math.min(leftOrRightSkyLine.get(row), topOrBottomSkyLine.get(col));
                 maxTotalSumOfIncreasedHeights += (maxHeight - grid[row][col]);
            }
        }
        return maxTotalSumOfIncreasedHeights;
    }

    private List<Integer> getTopOrBottomSkyLine(int[][] grid) {
        List<Integer> topOrBottomSkyLine = new ArrayList<>();
        for (int col = 0; col < grid.length; col++) {
            List<Integer> colTemp = new ArrayList<>();
            for (int row = 0; row < grid.length; row++) {
                colTemp.add(grid[row][col]);
            }
            topOrBottomSkyLine.add(colTemp.stream().mapToInt(a -> a).max().orElse(0));
        }
        return topOrBottomSkyLine;
    }

    private List<Integer> getLeftOrRightSkyLine(int[][] grid) {
        List<Integer> leftOrRightSkyLine = new ArrayList<>();
        for (int[] row : grid) {
            leftOrRightSkyLine.add(Arrays.stream(row).max().orElse(0));
        }
        return leftOrRightSkyLine;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] grid = {
            {3, 0, 8, 4},
            {2, 4, 5, 7},
            {9, 2, 6, 3},
            {0, 3, 1, 0}
        };
        System.out.println(new Solution().maxIncreaseKeepingSkyline(grid));
    }
}