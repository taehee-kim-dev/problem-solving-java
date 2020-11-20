package programmers.kakao;

import java.util.Stack;

public class CraneDollDrawGame {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> bucket = new Stack<>();

        for (int col : moves){
            int colIndex = col - 1;
            for (int rowIndex = 0; rowIndex < board.length; rowIndex++){
                if (board[rowIndex][colIndex] != 0){
                    if (bucket.isEmpty() || bucket.peek() !=
                            board[rowIndex][colIndex]){
                        bucket.add(board[rowIndex][colIndex]);
                    }else{
                        bucket.pop();
                        answer += 2;
                    }
                    board[rowIndex][colIndex] = 0;
                    break;
                }
            }

        }

        return answer;
    }



}

class Test{
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0}
                ,{0, 0, 1, 0, 3}
                ,{0, 2, 5, 0, 1}
                ,{4, 2, 4, 4, 2}
                ,{3, 5, 1, 3, 1}
        };

        int [] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(new CraneDollDrawGame().solution(board, moves));
    }
}
