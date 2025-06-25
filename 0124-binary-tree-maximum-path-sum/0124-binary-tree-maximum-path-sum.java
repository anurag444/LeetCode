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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);

        return max;
    }

    public int helper(TreeNode root){
        //base case
        if(root == null) return 0;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));


        int sum1 = Math.max(left + root.val, right + root.val);
        int sum2 = Math.max(root.val, left + root.val + right);

        int sum = Math.max(sum1, sum2);

        max = Math.max(max, sum);



        return Math.max(left, right) + root.val;
    }
}