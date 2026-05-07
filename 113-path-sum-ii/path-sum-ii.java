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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root, targetSum, list, ans);
        return ans;
    }

    public static void helper(TreeNode root, int target, List<Integer> list, List<List<Integer>> ans){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(target - root.val == 0) {
                ArrayList<Integer> temp = new ArrayList<>(list);
                temp.add(root.val);
                ans.add(temp);
            }
            return;
        }

        list.add(root.val);
        helper(root.left, target - root.val, list, ans);
        helper(root.right, target - root.val, list, ans);
        list.remove(list.size() - 1);
        return;
    }
}