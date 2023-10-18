/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    /*public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        return lowestCommonAncestor(root, A, B);
    }*/
    int counter = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = dfs(root, p, q);
        return counter == 2 ? result : null;
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);

        if (root == p || root == q) {
            counter++;
            return root;
        } 
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

}
