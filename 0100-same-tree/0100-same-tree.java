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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return checkSame(p, q, true);
    }

    public boolean checkSame(TreeNode p, TreeNode q, boolean same){
        if(same == false) return same;

        if(p == null && q == null){
                return true;
        }else if(p == null) return false;
        else if(q == null) return false;

        if(p.val == q.val){

            return checkSame(p.left, q.left, same) && checkSame(p.right, q.right, same);

        }
        else{
            same = false;
            return same;
        }
    }
}