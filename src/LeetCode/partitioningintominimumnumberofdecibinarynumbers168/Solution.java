package LeetCode.partitioningintominimumnumberofdecibinarynumbers168;

import java.util.Arrays;

class Solution {
    public int minPartitions(String n) {
        int maxValue = 0;
        for(char digit : n.toCharArray()) {
            if (digit - (int)'0' > maxValue) {
                maxValue = digit - (int)'0';
            }
        }
        return maxValue;
    }
}
