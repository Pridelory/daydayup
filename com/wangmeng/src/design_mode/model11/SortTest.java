package design_mode.model11;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 策略模式的一个应用
 *
 * 对不同对象提供不同的比较策略
 */
public class SortTest {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1,23,54,11,21};
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.intValue() < o2.intValue()) {
                    return 1;
                } else if (o1.intValue() == o2.intValue()) return 0;
                else return -1;
            }
        });
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
