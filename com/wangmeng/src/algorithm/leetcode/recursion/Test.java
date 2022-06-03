package algorithm.leetcode.recursion;

/**
 * @ClassName Test
 * @Description TODO
 * @Author wangmeng
 * @Date 2021/10/5
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {6, 3, 2, -5};
        System.out.println(sumRecursion(arr, arr.length - 1));
    }

    public static int sumRecursion(int[] arr, int index) {
        if (index < 0) return 0;
        return ((arr[index] < 0 || arr[index] % 2 == 0) ? arr[index] : 0) + sumRecursion(arr, index - 1);
    }
}
