package LeetCode.q654;


import com.sun.source.tree.Tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return makeBinaryTree(nums);
    }

    private TreeNode makeBinaryTree(int[] subarray) {
        if (subarray.length == 0) {
            return null;
        }
        int maxValueInSubArray = Arrays.stream(subarray).max()
            .orElseThrow(IllegalArgumentException::new);
        int indexOfMaxValueInSubArray = getIndexOfMaxValueInSubArray(subarray, maxValueInSubArray);
        int[] leftPrefix = getLeftPrefixOfSubArray(subarray, indexOfMaxValueInSubArray);
        int[] rightSuffix = getRightSuffixOfSubArray(subarray, indexOfMaxValueInSubArray);
        TreeNode currentNode = new TreeNode(maxValueInSubArray);
        currentNode.left = makeBinaryTree(leftPrefix);
        currentNode.right = makeBinaryTree(rightSuffix);
        return currentNode;
    }

    private int[] getLeftPrefixOfSubArray(int[] subarray, int indexOfMaxValueInSubArray) {
        List<Integer> leftSubArray = new ArrayList<>();
        for (int i = 0; i < indexOfMaxValueInSubArray; i++) {
            leftSubArray.add(subarray[i]);
        }
        return leftSubArray.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[] getRightSuffixOfSubArray(int[] subarray, int indexOfMaxValueInSubArray) {
        List<Integer> rightSubArray = new ArrayList<>();
        for (int i = indexOfMaxValueInSubArray + 1; i < subarray.length; i++) {
            rightSubArray.add(subarray[i]);
        }
        return rightSubArray.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getIndexOfMaxValueInSubArray(int[] subarray, int maxValueInSubArray) {
        for (int i = 0; i < subarray.length; i++) {
            if (subarray[i] == maxValueInSubArray) {
                return i;
            }
        }
        return -1;
    }
}