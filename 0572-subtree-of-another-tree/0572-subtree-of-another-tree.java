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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;

        if(subRoot == null || root == null) return false;

        return findSubTree(root, subRoot);
    }

    public boolean findSubTree(TreeNode root, TreeNode subRoot){
        if(root == null) return false;

        if(root.val == subRoot.val){
            TreeNode temp = subRoot;
            boolean isSubTree = checkSubTree(root, temp);
            if(isSubTree == true){
                return true;
            }
        }

        return findSubTree(root.left, subRoot) || findSubTree(root.right, subRoot);

    }

    public boolean checkSubTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;

        if(root == null || subRoot == null) return false;

        if(root.val != subRoot.val) return false;

        return checkSubTree(root.left, subRoot.left) && checkSubTree(root.right, subRoot.right);
    }
}