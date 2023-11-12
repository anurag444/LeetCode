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
    static int res = 0;
    static int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        kSmallestHelper(root);

        return res;
    }

    public void kSmallestHelper(TreeNode node){
        if(node == null){
            return;
        }

        kSmallestHelper(node.left);
        count--;
        if(count == 0){
            res = node.val;
            return;
        }

        kSmallestHelper(node.right);

    }
}