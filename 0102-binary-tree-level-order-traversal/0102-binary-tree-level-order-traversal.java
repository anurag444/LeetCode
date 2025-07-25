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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();


        Queue<TreeNode> q = new LinkedList<>();
        int size = 0;
        if(root == null) return res;

        q.add(root);

        while(!q.isEmpty()){

            size = q.size();
            List<Integer> list = new ArrayList<>();

            while(size != 0){
                TreeNode node = q.poll();

                list.add(node.val);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                size--;
            }

            res.add(list);

        }

        return res;
    }
}