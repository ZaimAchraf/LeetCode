/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

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

    Map<Integer, Node> map = new HashMap<>();

    public Node connect(Node root) {
        dfs(root, 0); 
        return root;
    }

    public void dfs(Node node, int level) {
        if (node == null) return;

        if (map.containsKey(level)) {
            map.get(level).next = node;
        }

        map.put(level, node);

        // Connect the left and right children
        if (node.left != null) {
            node.left.next = node.right;
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
