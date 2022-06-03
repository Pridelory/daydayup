package jvm.gc;

/**
 * @ClassName LongLiveObjAllocation
 * @Description Long live obj allocation
 * -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * @Author wangmeng
 * @Date 2022/5/31
 */
public class LongLiveObjAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testTenuringThreshold();
    }

    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        // 什么时候进入老年代决定于XX:MaxTenuring- Threshold设置
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
