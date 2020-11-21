package programmers.kakao.pressthekeypad;


import java.util.HashMap;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        HashMap<Integer, int[]> keypadPositions = new HashMap<>();
        keypadPositions.put(1, new int[]{0, 0});
        keypadPositions.put(2, new int[]{0, 1});
        keypadPositions.put(3, new int[]{0, 2});

        keypadPositions.put(4, new int[]{1, 0});
        keypadPositions.put(5, new int[]{1, 1});
        keypadPositions.put(6, new int[]{1, 2});

        keypadPositions.put(7, new int[]{2, 0});
        keypadPositions.put(8, new int[]{2, 1});
        keypadPositions.put(9, new int[]{2, 2});

        keypadPositions.put(0, new int[]{3, 1});

        int[] leftHandPosition = {3, 0};
        int[] rightHandPosition = {3, 2};

        for (int num : numbers){
            if (num == 1 || num == 4 || num == 7){
                answer += 'L';
                leftHandPosition = keypadPositions.get(num);
            }else if (num == 3 || num == 6 || num == 9){
                answer += 'R';
                rightHandPosition = keypadPositions.get(num);
            }else{
                int leftHandDiff = getDiff(leftHandPosition, num, keypadPositions);
                int rightHandDiff = getDiff(rightHandPosition, num, keypadPositions);
                if (leftHandDiff == rightHandDiff) {
                    if (hand.equals("right")) {
                        answer += 'R';
                        rightHandPosition = keypadPositions.get(num);
                    } else {
                        answer += 'L';
                        leftHandPosition = keypadPositions.get(num);
                    }
                }else if (leftHandDiff < rightHandDiff){
                    answer += 'L';
                    leftHandPosition = keypadPositions.get(num);
                }else{
                    answer += 'R';
                    rightHandPosition = keypadPositions.get(num);
                }
            }
        }

        return answer;
    }

    private int getDiff(int[] currentHandPosition, int num, HashMap<Integer, int[]> keypadPositions) {
        int[] nextNumPosition = keypadPositions.get(num);
        int xDiff = Math.abs(currentHandPosition[1] - nextNumPosition[1]);
        int yDiff = Math.abs(currentHandPosition[0] - nextNumPosition[0]);
        return xDiff + yDiff;
    }
}

class Test{
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String result = new Solution().solution(numbers, hand);
        System.out.println(result);
        System.out.println(result.equals("LRLLLRLLRRL"));
    }
}