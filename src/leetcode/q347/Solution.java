package leetcode.q347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class NumberCount {
    private final int number;
    private int count;

    public NumberCount(int number) {
        this.number = number;
        this.count = 1;
    }

    public int getNumber() {
        return number;
    }

    public int getCount() {
        return count;
    }

    public void plusCount() {
        count += 1;
    }
}

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, NumberCount> numberCounter = new HashMap<>();

        for (int num : nums) {
            if (numberCounter.containsKey(num)) {
                numberCounter.get(num).plusCount();
            } else {
                numberCounter.put(num, new NumberCount(num));
            }
        }

        List<NumberCount> numberCounts = new ArrayList<>(numberCounter.values());

        numberCounts = numberCounts.stream()
            .sorted((a, b) -> -Integer.compare(a.getCount(), b.getCount()))
            .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(numberCounts.get(i).getNumber());
        }

        return result.stream().mapToInt(a -> a).toArray();
    }
}
