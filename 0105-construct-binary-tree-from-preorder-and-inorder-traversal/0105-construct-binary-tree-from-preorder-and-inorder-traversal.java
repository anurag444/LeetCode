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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //Store the inorder in the hashmap
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = buildHelper(inorder, preorder, map, 0, inorder.length - 1, 0, preorder.length - 1);
        return root;
    }

    public TreeNode buildHelper(int[] inorder, int[] preorder, HashMap<Integer, Integer> map, int inStart, int inEnd, int preStart, int preEnd){
        //base case when no elements left
        if(inStart > inEnd || preStart > preEnd) return null;

        TreeNode node = new TreeNode(preorder[preStart]);

        int idx = map.get(node.val);
        int idxLeft = idx - inStart;


        node.left = buildHelper(inorder, preorder, map, inStart, idx - 1, preStart + 1, preStart + idxLeft);
        node.right = buildHelper(inorder, preorder, map, idx + 1, inEnd, preStart + idxLeft + 1, preEnd);

        return node;
    }
}