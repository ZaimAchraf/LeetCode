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
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        bfs(root, new ArrayList<Integer>(), 0, 0, targetSum);
        return results;
    }

    public void bfs(TreeNode node, List<Integer> list, int n, int sum, int targetSum) {
        if (node == null){
            
            return;
        }
        
        sum += node.val;

        list.add(n, node.val);
        
        if (sum == targetSum && node.left == null && node.right == null){
            results.add(new ArrayList<Integer>(list));
        }else {
            bfs(node.left, list, n+1, sum, targetSum);
            bfs(node.right, list, n+1, sum, targetSum);
        }
        
        list.remove(n);
    }
}