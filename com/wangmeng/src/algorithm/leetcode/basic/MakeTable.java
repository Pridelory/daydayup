package algorithm.leetcode.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MakeTable
 * @Description 打表
 * @Author wangmeng
 * @Date 2022/2/12
 */
public class MakeTable {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1, 3, 4, 6, 2, 7, 5, 3, 4, 9, 1, 8, 6, 8, 9, 7, 6, 4, 2, 1, 4, 4};
//        long start1 = System.currentTimeMillis();
//        System.out.println(new MakeTable().maxCountUsingHashMap(arr));
//        long end1 = System.currentTimeMillis();
//        long duration1 = end1 - start1;
//        System.out.println("maxCountUsingHashMap方法花费的时间为" + duration1 + " ms");
//        System.out.println("-----------------------------------");
//        long start2 = System.currentTimeMillis();
//        System.out.println(new MakeTable().maxCountUsingTable(arr));
//        long end2 = System.currentTimeMillis();
//        long duration2 = end2 - start2;
//        System.out.println("maxCountUsingTable方法花费的时间为" + duration2 + " ms");
        Arrays.sort(arr);
    }

    /**
     * make a table
     * @param arr
     * @return
     */
    public int maxCountUsingTable(int[] arr) {
        int[] table = new int[10];
        for (int i = 0; i < arr.length; i++) {
            table[arr[i]]++;
        }
        int index = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < table.length; i++) {
            if (table[i] > maxValue) {
                maxValue = table[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Give an arr
     * return the number that occurs most times
     *
     * using hashmap
     * @param arr
     * @return
     */
    public int maxCountUsingHashMap(int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        int key = 0;
        int value = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {
            if (map.getValue() > value) {
                value = map.getValue();
                key = map.getKey();
            }
        }
        return key;
    }
}
