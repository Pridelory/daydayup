package algorithm.leetcode.basic.queue;


import java.util.*;

/**
 * @ClassName MonotoneStack
 * @Description 单调栈
 * @Author wangmeng
 * @Date 2022/3/3
 */
public class MonotoneStack {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] res = new MonotoneStack().nextGreaterElements(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        int[] extendNums = new int[2 * nums.length];
        for (int i = 0; i < extendNums.length; i++) {
            if (i < nums.length) {
                extendNums[i] = nums[i];
            } else {
                extendNums[i] = nums[i - nums.length];
            }
        }

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < extendNums.length; i++) {
            while (!stack.isEmpty() && extendNums[stack.peek()] < extendNums[i]) {
                int currIdx = stack.pop();
                hashmap.put(currIdx, extendNums[i]);
            }
            stack.push(i);
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = hashmap.getOrDefault(i, -1);
        }
        return ans;
    }
}
