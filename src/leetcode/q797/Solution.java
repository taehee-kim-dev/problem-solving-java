package leetcode.q797;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        findPaths(graph, allPaths, new ArrayList<>(), 0, graph.length - 1);
        return allPaths;
    }

    private void findPaths(int[][] graph, List<List<Integer>> allPaths, List<Integer> currentPath,
        int currentNodeIndex, int destinationNodeIndex) {
        currentPath.add(currentNodeIndex);
        if (currentNodeIndex == destinationNodeIndex) {
            allPaths.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size() - 1);
            return;
        }
        int[] nextNodeIndexes = graph[currentNodeIndex];
        for (int nextNodeIndex : nextNodeIndexes) {
            findPaths(graph, allPaths, currentPath, nextNodeIndex, destinationNodeIndex);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}

class Test {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(new Solution().allPathsSourceTarget(graph));
    }
}