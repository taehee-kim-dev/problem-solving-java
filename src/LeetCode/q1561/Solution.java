package LeetCode.q1561;

import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {
        int answer = 0;
        Arrays.sort(piles);
        for (int i = piles.length / 3; i < piles.length; i += 2) {
            answer += piles[i];
        }
        return answer;
    }
}