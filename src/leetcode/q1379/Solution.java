package leetcode.q1379;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned,
        final TreeNode target) {
        if (original == null || original == target) {
            return cloned;
        }
        TreeNode node =  getTargetCopy(original.left, cloned.left, target);
        if (node != null) {
            return node;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }
}