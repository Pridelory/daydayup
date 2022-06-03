package jvm.gc;

/**
 * @ClassName BigObjAllocation
 * @Description Big Object Allocation
 * -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * @Author wangmeng
 * @Date 2022/5/31
 */
public class BigObjAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }

    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        //直接分配在老年代中
        allocation = new byte[5 * _1MB];
    }
}
