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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int result = dfs(root);
        if (result > max) max = result;
        return max;
    }

    public int dfs (TreeNode node) {
        int maxLeft, maxRight, localMax;

        if (node.left != null && node.right != null) {
            maxLeft = dfs (node.left);
            maxRight = dfs (node.right);

            if ((maxLeft + maxRight + node.val) > max) max = maxLeft + maxRight + node.val;
            if (maxLeft > max) max = maxLeft;
            if (maxRight > max) max = maxRight;

            return Math.max(Math.max(maxLeft + node.val, maxRight + node.val), node.val);



        }else if (node.right != null) {
            maxRight = dfs (node.right);
            if (maxRight > max) max = maxRight;

            return Math.max(maxRight + node.val, node.val);

        }else if (node.left != null) {
            maxLeft = dfs (node.left);
            if (maxLeft > max) max = maxLeft;

            return Math.max(maxLeft + node.val, node.val);
        }
        
        return node.val;

    }
}