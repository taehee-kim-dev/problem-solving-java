package leetcode.q1446;

class CurrentStatus {

    private final int maxPower;
    private final int currentPower;
    private final char currentChar;

    public CurrentStatus(char firstChar) {
        this(1, 1, firstChar);
    }

    public CurrentStatus(
        int maxPower,
        int currentPower,
        char currentChar
    ) {
        this.maxPower = maxPower;
        this.currentPower = currentPower;
        this.currentChar = currentChar;
    }

    public boolean isCurrentCharSameAs(char otherChar) {
        return this.currentChar == otherChar;
    }

    public CurrentStatus increasePower() {
        int newCurrentPower = this.currentPower + 1;
        int newMaxPower = getNewMaxPower(newCurrentPower);

        return new CurrentStatus(newMaxPower, newCurrentPower, this.currentChar);
    }

    private int getNewMaxPower(int newCurrentPower) {
        return Math.max(this.maxPower, newCurrentPower);
    }

    public int getMaxPower() {
        return maxPower;
    }
}

class Solution {

    public int maxPower(String inputStr) {

        CurrentStatus currentStatus = getCurrentStatusOf(inputStr);

        for (int inputStrIndex = 1; inputStrIndex < inputStr.length(); inputStrIndex++) {
            char currentChar = inputStr.charAt(inputStrIndex);

            if (currentStatus.isCurrentCharSameAs(currentChar)) {
                currentStatus = currentStatus.increasePower();
                continue;
            }

            currentStatus = new CurrentStatus(currentStatus.getMaxPower(), 1, currentChar);
        }

        return currentStatus.getMaxPower();
    }

    private CurrentStatus getCurrentStatusOf(String inputStr) {
        char firstCharOfInputStr = inputStr.charAt(0);
        return new CurrentStatus(firstCharOfInputStr);
    }
}

class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxPower("leetcode");
    }
}
