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
    public boolean isValidBST(TreeNode root) {
        double inf = - 1 - 1 * Math.pow(2, 31) ;
        double sup = Math.pow(2, 31) + 1;
        return rec(root, sup, inf);
    }

    public boolean rec(TreeNode node, double sup, double inf) {
        if (node == null) return true;

        if (node.val >= sup || node.val <= inf ) {
            return false;
        }

        return rec(node.left, node.val, inf) && rec(node.right, sup, node.val);
    }
}