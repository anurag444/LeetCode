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
    boolean isBal = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        getHeight(root);
    
        return isBal; 
    }

    public int getHeight(TreeNode node){

        if(node == null){
            return 0;
        }

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        if(Math.abs(left - right) > 1) isBal = false;

        return 1 + Math.max(left, right);
    }
}