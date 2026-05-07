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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return helper(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, hm);
    }

    private TreeNode helper(int[] postorder, int postSt, int postEnd, int[] inorder, int inSt, int inEnd, HashMap<Integer,Integer> hm){
        if(postSt>postEnd || inSt>inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inorderIdx = hm.get(root.val);
        int numsLeft = inorderIdx-inSt;
        root.left = helper(postorder, postSt, postSt+numsLeft-1, inorder, inSt, inorderIdx-1, hm);
        root.right = helper(postorder, postSt+numsLeft, postEnd-1, inorder, inorderIdx+1, inEnd, hm);
        return root;
    }
}