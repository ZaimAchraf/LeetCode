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
    int result = 0;
    int maxLevel = 0;

    // public int sumNumbers(TreeNode root) {
    //     dfs(root, new StringBuffer());
    //     return result;
    // }

    // public void dfs (TreeNode node, StringBuffer strNum) {
    //     if (node == null) return;

    //     strNum.append("" + node.val);

    //     if (node.left == null && node.right == null) {
    //         try {
    //             result += Integer.parseInt(strNum.toString());
    //         }catch(Exception ex) {
    //             return;
    //         }
    //     }else {
    //         dfs(node.left, strNum);
    //         dfs(node.right, strNum);
    //     }
    //     strNum.deleteCharAt(strNum.length() -1);
    // }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    public void dfs (TreeNode node, int currentSum) {
        if (node == null) return;

        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            result += currentSum;
            
        }else {
            dfs(node.left, currentSum);
            dfs(node.right, currentSum);
        }
    }

}