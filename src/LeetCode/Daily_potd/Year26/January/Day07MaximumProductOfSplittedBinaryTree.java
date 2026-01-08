package LeetCode.Daily_potd.Year26.January;



// Definition for a binary tree node.
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


class Day07MaximumProductOfSplittedBinaryTree {

    // Approach:
    // First, compute the total sum of all nodes in the binary tree using postorder traversal.
    // Then, traverse the tree again and consider each subtree as one part after splitting.
    // For a subtree with sum = x, the other part will have sum = (totalSum - x).
    // The product after splitting is: x * (totalSum - x).
    // We calculate this product for both left and right subtrees at every node
    // and keep track of the maximum product found.

    // Time Complexity: O(N)
    //   - Each node is visited twice (once for total sum, once for product calculation)

    // Space Complexity: O(H)
    //   - Recursion stack space, where H is the height of the tree
    //   - Worst case: O(N) for a skewed tree

    long max = 0;
    long sum = 0;

    public int maxProduct(TreeNode root) {
        int mod = (int) 1e9 + 7;
        sum = postorder(root, 0);
        product(root);
        return (int) (max % mod);
    }

    public long product(TreeNode root){
        if(root == null) return 0;
        long l = product(root.left);
        long r = product(root.right);
        long lsum = (sum - l) * l;
        long rsum = (sum - r) * r;
        max = Math.max(Math.max(lsum, rsum), max);
        return l + r + root.val;
    }

    public long postorder(TreeNode root, long sum){
        if(root == null) return 0;
        long l = postorder(root.left, sum);
        long r = postorder(root.right, sum);
        sum = sum + root.val;
        return sum + l + r;
    }
}
