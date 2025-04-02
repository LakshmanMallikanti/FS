package Trees;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreefromPP {
    public static void main(String[] args) {

    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return buildTree(preorder, postorder, postIndexMap, new int[] { 0 }, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] postorder, Map<Integer, Integer> postIndexMap, int[] preIndex,
            int left, int right) {
        if (left > right || preIndex[0] >= preorder.length)
            return null;

        TreeNode root = new TreeNode(preorder[preIndex[0]++]);

        if (left == right || preIndex[0] >= preorder.length)
            return root;

        int leftSubtreeRootIndex = postIndexMap.get(preorder[preIndex[0]]);

        root.left = buildTree(preorder, postorder, postIndexMap, preIndex, left, leftSubtreeRootIndex);
        root.right = buildTree(preorder, postorder, postIndexMap, preIndex, leftSubtreeRootIndex + 1, right - 1);

        return root;
    }
}
