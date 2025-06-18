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
        maxSumHelper(root);

        return max;
    }

    public int maxSumHelper(TreeNode root){
        if(root == null) return 0;

        int left = maxSumHelper(root.left);
        int right = maxSumHelper(root.right);

        int sum3 = Math.max(left + root.val, right + root.val);


        int sum1 = Math.max(left + right + root.val, root.val);

        int sum = Math.max(sum3, sum1);

        if(sum > max){
            max = sum;
        }

        return Math.max(sum3, root.val);
    }
}