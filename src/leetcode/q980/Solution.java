package leetcode.q980;

class Solution {
    private int remainingNumberOfNonObstacleSquares;
    private final int[] startingSquarePoint = new int[2];
    private final int[] endingSquarePoint = new int[2];
    private boolean[][] visited;
    private int answer = 0;
    private int m;
    private int n;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        getNumberOfNonObstacleSquares(grid);
        setVisited(grid);
        findPaths(startingSquarePoint[0], startingSquarePoint[1]);
        return answer;
    }

    private void getNumberOfNonObstacleSquares(int[][] grid) {
        int numberOfNonObstacleSquares = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    startingSquarePoint[0] = row;
                    startingSquarePoint[1] = col;
                }
                if (grid[row][col] == 2) {
                    endingSquarePoint[0] = row;
                    endingSquarePoint[1] = col;
                }
                if (grid[row][col] != -1) {
                    numberOfNonObstacleSquares++;
                }
            }
        }
        remainingNumberOfNonObstacleSquares = numberOfNonObstacleSquares;
    }

    private void setVisited(int[][] grid) {
        visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == -1) {
                    visited[row][col] = true;
                }
            }
        }
    }

    private void findPaths(int currentRow, int currentCol) {
        visited[currentRow][currentCol] = true;
        remainingNumberOfNonObstacleSquares--;
        if (currentRow == endingSquarePoint[0] && currentCol == endingSquarePoint[1]
            && remainingNumberOfNonObstacleSquares == 0) {
            answer++;
            visited[currentRow][currentCol] = false;
            remainingNumberOfNonObstacleSquares++;
            return;
        }
        if (0 <= currentRow - 1 && !visited[currentRow - 1][currentCol]) {
            findPaths(currentRow - 1, currentCol);
        }
        if (currentRow + 1 < m && !visited[currentRow + 1][currentCol]) {
            findPaths(currentRow + 1, currentCol);
        }
        if (0 <= currentCol - 1 && !visited[currentRow][currentCol - 1]) {
            findPaths(currentRow, currentCol - 1);
        }
        if (currentCol + 1 < n && !visited[currentRow][currentCol + 1]) {
            findPaths(currentRow, currentCol + 1);
        }
        visited[currentRow][currentCol] = false;
        remainingNumberOfNonObstacleSquares++;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] input = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(new Solution().uniquePathsIII(input));
    }
}