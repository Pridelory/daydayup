package java_basic.string;

/**
 * @ClassName StringBufferAndBuilder
 * @Description StringBuffer和StringBuilder的区别
 *
 * 他们原理和操作基本相同
 * StringBuffer支持并发，是线程安全的
 * 而StringBuilder不支持并发，线程不安全
 * 所以相比下StringBuilder效率要高一些
 * @Author wangmeng
 * @Date 2021/6/28
 */
public class StringBufferAndBuilder {
    public static void main(String[] args) {
        new StringBuilder();
    }
}
