/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return max;
        } 

        if (root.left == null && root.right == null) {
            return 1;
        }

        postOrder(1, root);
        return max;
    }

    public void postOrder(int depth, TreeNode root) {
        if (root == null) {
            max = Math.max(depth - 1, max);
            return;
        }

        postOrder(depth + 1, root.left);
        postOrder(depth + 1, root.right);
    }
}