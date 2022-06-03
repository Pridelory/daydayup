package jvm.method_area;


/**
 * @ClassName MetaspaceOverflow
 * @Description -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * 模拟元空间溢出
 * 元空间 使用的是本地内存 当加载到内存中的class太多或者太大 就会发生元空间溢出
 * @Author wangmeng
 * @Date 2022/5/31
 */
public class MetaspaceOverflow {

    public static void main(String[] args) {
        
    }
}
