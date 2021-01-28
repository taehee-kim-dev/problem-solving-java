package LeetCode.q1725;

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int answer = 0;
        for (int[] rectangle : rectangles) {
            int minLengthOfRectangle = Math.min(rectangle[0], rectangle[1]);
            if (minLengthOfRectangle > maxLen) {
                maxLen = minLengthOfRectangle;
                answer = 1;
                continue;
            }
            if (minLengthOfRectangle == maxLen) {
                answer++;
            }
        }
        return answer;
    }
}