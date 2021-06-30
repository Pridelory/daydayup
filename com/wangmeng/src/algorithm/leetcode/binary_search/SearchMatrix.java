package algorithm.leetcode.binary_search;

/**
 * @ClassName SearchMatrix
 * @Description
 * 搜索二维矩阵
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * @Author wangmeng
 * @Date 2021/3/30
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new SearchMatrix().searchMatrix(matrix, 1));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = searchRows(matrix, target);
        if (rowNum < 0) return false;
        return searchCols(matrix[rowNum], target);
    }

    /**
     * 找到行号
     * @return
     */
    public int searchRows(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        while (i < j) {
            int mid = i + (j - i + 1) / 2;
            if (matrix[mid][0] <= target) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }

    /**
     * 在相应的行里找target
     * @return
     */
    public boolean searchCols(int[] rows, int target) {
        int i = 0;
        int j = rows.length - 1;
        while (i <= j) {
            int mid = i + (j - i + 1) / 2;
            if (rows[mid] == target) {
                return true;
            } else if (rows[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}
