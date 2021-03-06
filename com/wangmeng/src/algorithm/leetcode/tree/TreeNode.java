package algorithm.leetcode.tree;

/**
 * @ClassName TreeNode
 * @Description 树定义
 * @Author wangmeng
 * @Date 2021/2/25
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
