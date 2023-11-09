/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = root;
        if(root == null) return null;
        lcaHelper(root, p , q);

        return ans;
    }

    public boolean lcaHelper(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return false;

        boolean left = lcaHelper(node.left, p, q);
        boolean right = lcaHelper(node.right, p, q);
        
        if((node.val == p.val || node.val == q.val) && (left || right)){
            ans = node;
            return true;
        } 

        if(left && right){
            ans = node;
        }

        if(node.val == p.val || node.val == q.val) return true;

        return left || right;
    }
}