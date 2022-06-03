package algorithm.leetcode.list;

/**
 * @ClassName LastRemaining
 * @Description 约瑟夫环 递推公式 f(n, m) = (f(n - 1, m) + m) % n
 * @Author wangmeng
 * @Date 2022/1/4
 */
public class LastRemaining {

    public static void main(String[] args) {
        System.out.println(new LastRemaining().lastRemaining1(9));
    }

    // 暴力，当n很大时，会超出内存限制
    public int lastRemaining1(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        boolean flag = true;
        while (arr.length > 1) {
            int[] temp = new int[arr.length / 2];
            if (flag) {
                int curr = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i % 2 != 0) temp[curr++] = arr[i];
                }
                arr = temp;
                flag = false;
            } else {
                int curr = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr.length % 2 == 0) {
                        if (i % 2 == 0) temp[curr++] = arr[i];
                    } else {
                        if (i % 2 != 0) temp[curr++] = arr[i];
                    }
                }
                arr = temp;
                flag = true;
            }
        }
        return arr[0];
    }

    // 约瑟夫环的应用
    public int lastRemaining2(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining2(n / 2));
    }
}
