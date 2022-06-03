package algorithm.leetcode.search;

import algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PathSum2
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/2/8
 */
public class PathSum2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode second = new TreeNode(4);
        TreeNode third = new TreeNode(8);
        TreeNode fourth = new TreeNode(11);
        TreeNode fifth = new TreeNode(13);
        TreeNode sixth = new TreeNode(4);
        TreeNode seventh = new TreeNode(7);
        TreeNode eigth = new TreeNode(2);
        TreeNode ninth = new TreeNode(5);
        TreeNode tenth = new TreeNode(1);

        root.left = second;
        root.right = third;
        second.left = fourth;
        third.left = fifth;
        third.right = sixth;
        fourth.left = seventh;
        fourth.right = eigth;
        sixth.left = ninth;
        sixth.right = tenth;

//        TreeNode root = new TreeNode(-2);
//        root.right = new TreeNode(-3);

        List<List<Integer>> lists = new PathSum2().pathSum(root, 22);
        System.out.println(lists);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(ans, path, root, targetSum);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> path, TreeNode root, int targetSum) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            ans.add(new ArrayList<>(path));
            return;
        }

        dfs(ans, path, root.left, targetSum - root.val);
        dfs(ans, path, root.right, targetSum - root.val);
        path.remove(path.size() - 1);
    }
}
