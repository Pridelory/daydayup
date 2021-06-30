package design_mode.model7;

import java.util.Random;

public class GenerateThread extends Thread {

    Long seconds;

    Long sum;

    int[] rangeArray;

    public GenerateThread(Long seconds, Long sum, int[] rangeArray) {
        this.seconds = seconds;
        this.sum = sum;
        this.rangeArray = rangeArray;
    }

    public void run() {
        Long tempSum = 0l;
        Long tempSecond = seconds;
        while (tempSecond-- > 0) {
            //产生随机数下标
            int min = 0;
            int max = rangeArray.length;
            Random random = new Random();
            int index = random.nextInt(max) % (max - min + 1) + min;

            //tempSum为动态增长的总人数
            tempSum += rangeArray[index];

            //打印当前总人数
            System.out.println(tempSum);

            //如果当前人数大于生成总人数 退出
            if (tempSum >= sum) break;

            //每秒生成一个
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
