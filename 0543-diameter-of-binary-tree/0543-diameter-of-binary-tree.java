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
    //global variable
    int maxi = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);

        return maxi;
    }

    public int findMax(TreeNode node){
        if(node == null) return 0; //base case

        int l = findMax(node.left);
        int r = findMax(node.right);

        maxi = Math.max(maxi, l + r);

        return 1 + Math.max(l, r);
    }
}