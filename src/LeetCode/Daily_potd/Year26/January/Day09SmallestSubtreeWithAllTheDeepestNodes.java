package LeetCode.Daily_potd.Year26.January;

// Definition for a binary tree node.
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

class Day09SmallestSubtreeWithAllTheDeepestNodes {

    // Approach:
    // We use a DFS-based postorder traversal.
    // For every node, we compute:
    //   1. The depth of its deepest subtree
    //   2. The node which is the smallest subtree containing all deepest nodes
    //
    // Logic:
    // - If left and right subtree depths are equal,
    //   then current node is the answer for this subtree.
    // - If left subtree is deeper, propagate left result.
    // - If right subtree is deeper, propagate right result.
    //
    // This ensures the lowest (smallest) subtree
    // that contains all deepest nodes is returned.

    // Time Complexity: O(N)
    //   - Each node is visited once
    //
    // Space Complexity: O(H)
    //   - Recursion stack, where H is the height of the tree
    //   - Worst case: O(N) for a skewed tree

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Pair dfs(TreeNode root) {
        if (root == null) return new Pair(null, 0);

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if (left.depth == right.depth) {
            return new Pair(root, left.depth + 1);
        } else if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        } else {
            return new Pair(right.node, right.depth + 1);
        }
    }

    // Helper class to store node and its depth
    class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // ------------------------------------------------------------
    // My HashSet + BFS Solution (Alternative Approach)
    // ------------------------------------------------------------
    /*
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        HashSet<TreeNode> set = new HashSet<>();

        // BFS to find all deepest nodes
        while (!q.isEmpty()) {
            int size = q.size();
            set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                set.add(temp);

                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }
        }

        // Find smallest subtree containing all deepest nodes
        return find(root, set);
    }

    private TreeNode find(TreeNode root, HashSet<TreeNode> set) {
        if (root == null) return null;
        if (set.contains(root)) return root;

        TreeNode left = find(root.left, set);
        TreeNode right = find(root.right, set);

        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
    */
}
