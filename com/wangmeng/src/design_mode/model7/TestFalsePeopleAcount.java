package design_mode.model7;

public class TestFalsePeopleAcount {
    public static void main(String[] args) {
        new TestFalsePeopleAcount().generateSumWithTime(3000l, 9000l);
    }

    /**
     * 根据指定时间动态生成指定人数(每秒打印)
     * @param seconds
     * @param sum
     */
    public void generateSumWithTime(Long seconds, Long sum) {
        //每次平均产生的人数(包括负数) 总人数除以秒 向上取整（提前生成完）
        int average = (int) Math.floor(sum / seconds) + 1;

        //构造浮动数组范围为 +-15 可以根据需求更改
        int floatRange = 15;

        //先假设average小于10 （0，10）
        int[] rangeArray = new int[30];
        int temp = average;
        //构造浮动数组
        for (int i = 0; i < 30; i++, temp++) {
            rangeArray[i] = temp - floatRange;
        }
        //启动多线程
        new GenerateThread(seconds, sum, rangeArray).start();
    }
}