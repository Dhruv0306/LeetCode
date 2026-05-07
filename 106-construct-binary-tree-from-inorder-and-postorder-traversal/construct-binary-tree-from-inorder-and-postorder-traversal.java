class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
        
        if (inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(post[postEnd]);

        int rootIdx = 0;
        for (int k = inStart; k <= inEnd; k++) {
            if (in[k] == post[postEnd]) {
                rootIdx = k;
                break;
            }
        }

        int leftSize = rootIdx - inStart;

        root.left = build(in, inStart, rootIdx - 1, 
                          post, postStart, postStart + leftSize - 1);

        root.right = build(in, rootIdx + 1, inEnd, 
                           post, postStart + leftSize, postEnd - 1);

        return root;
    }
}
