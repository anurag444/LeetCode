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
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) return true;

        isValidBSTRec(root, res);

        int n = res.size();
        for(int i = 0; i < n- 1; i++){
            if(res.get(i) >= res.get(i + 1)) return false;
        }

        return true;
    }

    public void isValidBSTRec(TreeNode node, List<Integer> res){
        if(node == null) return;

        isValidBSTRec(node.left, res);
        res.add(node.val);
        isValidBSTRec(node.right, res);

    }
}