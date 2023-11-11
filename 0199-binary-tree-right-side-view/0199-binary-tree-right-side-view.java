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
    // RECURSIVE APPROACH
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        //base case
        if(root == null) return res;
        rightViewHelper(root, res, 0);
        return res;
    }

    public void rightViewHelper(TreeNode node, List<Integer> res, int depth){
        if(node == null){
            return;
        }

        if(depth == res.size()){
            res.add(node.val);
        }

        rightViewHelper(node.right, res, depth + 1);
        rightViewHelper(node.left, res, depth + 1);

    }





    // ITERATIVE APPROCH
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();

    //     //base case
    //     if(root == null) return res;

    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.add(root);

    //     while(!q.isEmpty()){
    //         int size = q.size();

    //         for(int i = 0; i < size; i++){
    //             TreeNode node = q.remove();
    //             if(i == size - 1){
    //                 res.add(node.val);
    //             }
    //             if(node.left != null) q.add(node.left);
    //             if(node.right != null) q.add(node.right);
    //         }
    //     }

    //     return res;
    // }
}