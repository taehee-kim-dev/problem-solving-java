package leetcode.q2011;

class Solution {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            if (operation.contains("+")) {
                x += 1;
                continue;
            }
            if (operation.contains("-")) {
                x -= 1;
            }
        }
        return x;
    }
}
