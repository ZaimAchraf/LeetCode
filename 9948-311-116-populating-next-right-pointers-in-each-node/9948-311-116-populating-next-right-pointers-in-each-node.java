/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;²²

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // Map<Integer, Node> map = new HashMap<Integer, Node>();

    public Node connect(Node root) {
        dfs(root);
        return root;
    }

// APPROACH 01 :
/*  public void dfs(Node node, Integer nv) {
        if (node == null) return;

        if(node.right != null) node.left.next = node.right;

        if (map.get(nv) != null) {
            map.get(nv).next = node;
            map.remove(nv);
        }

        if (node.next == null) map.put(nv, node);

        dfs(node.left, nv + 1);
        dfs(node.right, nv + 1);
    }
*/

// APPROACH 02 :
    private void dfs(Node node) {
        if (node == null) return;

        if (node.left != null) {
            node.left.next = node.right;
        }

        if (node.right != null && node.next != null) {
            node.right.next = node.next.left;
        }

        dfs(node.left);
        dfs(node.right);
    }
}