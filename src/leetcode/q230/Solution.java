package leetcode.q230;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int k;
    private int count;
    private int answer;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        count = 0;
        inorder(root);
        return answer;
    }

    private void inorder(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }
        inorder(currentNode.left);
        count += 1;
        if (count == k) {
            answer = currentNode.val;
            return;
        }
        inorder(currentNode.right);
    }
}