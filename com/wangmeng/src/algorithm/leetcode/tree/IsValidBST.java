package algorithm.leetcode.tree;

/**
 * @ClassName IsValidBST
 * @Description
 * @Author wangmeng
 * @Date 2022/2/6
 */
public class IsValidBST {

    long rollVal = (long) Integer.MIN_VALUE - 1;

    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        head.left = new TreeNode(1);
        head.right = new TreeNode(3);
        System.out.println(new IsValidBST().isValidBST(head));
    }


    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean leftFlag = isValidBST(root.left);
        if (root.val <= rollVal) {
            return false;
        } else {
            rollVal = root.val;
        }
        boolean rightFlag = isValidBST(root.right);
        return leftFlag && rightFlag;
    }
}
