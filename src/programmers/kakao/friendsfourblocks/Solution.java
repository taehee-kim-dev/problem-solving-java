package programmers.kakao.friendsfourblocks;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] mainBoard = new char[m][n];
        setInitialBoard(board, mainBoard);

        int removedCount = 0;
        do {
            boolean[][] checkedBoardToRemove = new boolean[m][n];
            checkToRemove(mainBoard, checkedBoardToRemove);
            removedCount = removeChecked(mainBoard, checkedBoardToRemove);

            char[][] arrangedBoard = new char[m][n];
            arrangeBoard(mainBoard, arrangedBoard);

            mainBoard = arrangedBoard;
            answer += removedCount;
        } while (removedCount > 0);


        return answer;
    }

    private void arrangeBoard(char[][] mainBoard, char[][] arrangedBoard) {
        for (int col = 0; col < mainBoard.length; col++) {
            int currentRowToInsert = arrangedBoard.length - 1;
            for (int row = mainBoard.length - 1; 0 <= row; row--) {
                if (mainBoard[row][col] != 'x') {
                    arrangedBoard[currentRowToInsert][col] = mainBoard[row][col];
                    currentRowToInsert--;
                }
            }
        }
    }

    private int removeChecked(char[][] initialBoard, boolean[][] checkedBoardToRemove) {
        int removedBlocksCount = 0;
        for (int row = 0; row < checkedBoardToRemove.length; row++) {
            for (int col = 0; col < checkedBoardToRemove[row].length; col++) {
                if (checkedBoardToRemove[row][col]) {
                    initialBoard[row][col] = 'x';
                    removedBlocksCount++;
                }
            }
        }
        return removedBlocksCount;
    }

    private void checkToRemove(char[][] initialBoard, boolean[][] checkedBoardToRemove) {
        for (int row = 0; row < initialBoard.length - 1; row++) {
            for (int col = 0; col < initialBoard[row].length - 1; col++) {
                char friendToRemove = initialBoard[row][col];
                if (friendToRemove != 0) {
                    if (initialBoard[row][col + 1] == friendToRemove
                        && initialBoard[row + 1][col] == friendToRemove
                        && initialBoard[row + 1][col + 1] == friendToRemove){
                        checkedBoardToRemove[row][col] = true;
                        checkedBoardToRemove[row][col + 1] = true;
                        checkedBoardToRemove[row + 1][col] = true;
                        checkedBoardToRemove[row + 1][col + 1] = true;
                    }
                }
            }
        }
    }

    private void setInitialBoard(String[] board, char[][] initialBoard) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length(); col++) {
                initialBoard[row][col] = board[row].charAt(col);
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(
            6, 6,
            new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}
        ));
    }
}
