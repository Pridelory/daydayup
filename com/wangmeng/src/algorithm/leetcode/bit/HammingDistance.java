package algorithm.leetcode.bit;

/**
 * @ClassName HammingDistance
 * @Description TODO
 * @Author wangmeng
 * @Date 2021/11/8
 */
public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(new HammingDistance().count(1, 4));
    }

    public int count(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
