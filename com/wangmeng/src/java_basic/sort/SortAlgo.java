package java_basic.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName SortAlgo
 * @Description sort algorithm
 * @Author wangmeng
 * @Date 2022/1/24
 */
public class SortAlgo {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 11, 34, 2, 7, 9};
        int[][] arrTD = {{2, 6}, {1, 3}, {8, 11}, {9, 20}};
        new SortAlgo().sortLambda(arr, arrTD);
        for (int t : arr) {
            System.out.print(t + " ");
        }
        System.out.println("---------------------------");
    }

    public void sortLambda(int[] arr, int[][] arrTD) {
        // 比较器泛型不能是基本数据类型，可以是包装数据类型或数组类型,e.g. int[]
        Arrays.sort(arrTD, (o1, o2) -> o1[0] - o2[0]);
    }
}
