package leetcode.q2006;

import java.util.HashMap;
import java.util.Map;

/**
 * ｜nums[i] - nums[j]｜ = k
 * nums[i] - nums[j] = ± k
 * nums[i] = nums[j] ± k
 * */
class Solution {

    public int countKDifference(int[] nums, int k) {
        int numberOfPairs = 0;

        Map<Integer, Integer> currentCountsOfEachNumber = new HashMap<>();
        for (int num : nums) {
            currentCountsOfEachNumber.put(num, currentCountsOfEachNumber.getOrDefault(num, 0) + 1);
            numberOfPairs += currentCountsOfEachNumber.getOrDefault(num - k, 0) + currentCountsOfEachNumber.getOrDefault(num + k, 0);
        }

        return numberOfPairs;
    }
}
