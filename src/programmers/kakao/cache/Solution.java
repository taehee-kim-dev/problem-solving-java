package programmers.kakao.cache;

import java.util.LinkedList;
import java.util.List;

class Cache {
    private final int capacity;
    private int currentSize;
    private final List<String> cache;

    public Cache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.cache = new LinkedList<>();
    }

    public int findAndGetRuntime(String city) {
        if (cache.contains(city)) {
            cache.remove(city);
            cache.add(0, city);
            return 1;
        }

        if (currentSize == capacity) {
            cache.remove(cache.size() - 1);
            cache.add(0, city);
            return 5;
        }

        cache.add(0, city);
        currentSize++;
        return 5;
    }
}

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        Cache cache = new Cache(cacheSize);
        for (String city : cities) {
            answer += cache.findAndGetRuntime(city);
        }

        return answer;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(
            3,
            new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}
        ));
    }
}
