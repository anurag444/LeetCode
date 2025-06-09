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
    public TreeNode invertTree(TreeNode root) {
        //Iterative
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return root;

        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            TreeNode left = curr.left;
            TreeNode right = curr.right;

            curr.left = right;
            curr.right = left;

            if(left != null) q.add(left);
            if(right != null) q.add(right);
        }

        return root;


        //Recursive
        // if(root == null) return root;

        // TreeNode left = invertTree(root.left);
        // TreeNode right = invertTree(root.right);

        // root.left = right;
        // root.right = left;
        // return root;
    }
}