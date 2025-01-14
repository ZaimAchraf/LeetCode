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
    List<TreeNode> orderedList = new ArrayList<>();
    

    public void recoverTree(TreeNode root) {
        int i = -1, j = -1, temp;
        orderedBts(root);
        
        for (int k = 0; k < orderedList.size() - 1; k++) {
            if (orderedList.get(k).val > orderedList.get(k+1).val) {
                if (i == -1) {
                    i = k;
                    continue;
                }
                else {
                    j = k;
                    break;
                } 
            }
        }

        // System.out.println(orderedList.get(1).val);
        // System.out.println(root);

        if (j == -1) {
            temp = orderedList.get(i).val;
            orderedList.get(i).val = orderedList.get(i+1).val;
            orderedList.get(i+1).val = temp;
        }
        else {
            temp = orderedList.get(i).val;
            orderedList.get(i).val = orderedList.get(j+1).val;
            orderedList.get(j+1).val = temp;
        } 
    }

    public void orderedBts(TreeNode node) {

        if (node == null) return;

        orderedBts(node.left);
        orderedList.add(node);
        // System.out.println(node.val);
        orderedBts(node.right);
    }
}

// 1 9 4 8 3 10 16
// 1 4 3 8 9 10 16