package algorithm.leetcode.binary_search;


/**
 * @ClassName BinarySearch
 * @Description
 * 二分查找 递归 非递归
 * @Author wangmeng
 * @Date 2021/3/30
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1,4,14,16,23,45,67,94};
        int len = array.length;
        System.out.println(new BinarySearch().binarySearchRecursively(array, 0, len - 1, 15));
    }

    /**
     * 二分查找非递归
     * @param array
     * @param target
     * @return
     */
    public boolean binarySearch(int[] array, int target) {
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            int mid = i + (j - i + 1) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }

    /**
     * 二分查找 递归
     * @param array
     * @param i
     * @param j
     * @param target
     * @return
     */
    public boolean binarySearchRecursively(int[] array, int i, int j,int target) {
        if (i > j) return false;
        int mid = i + (j - i + 1) / 2;
        if (array[mid] == target) return true;
        if (array[mid] > target) {
            return binarySearchRecursively(array, i, mid - 1, target);
        }
        if (array[mid] < target) {
            return binarySearchRecursively(array, mid + 1, j, target);
        }
        return false;
    }
}
