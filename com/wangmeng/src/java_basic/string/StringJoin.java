package java_basic.string;

import java.util.ArrayList;

/**
 * @ClassName StringJoin
 * @Description Usage of join
 * @Author wangmeng
 * @Date 2021/9/29
 */
public class StringJoin {
    public static void main(String[] args) {
        ArrayList<String> strs = new ArrayList<>();
        strs.add("he");
        strs.add("llo");
        strs.add("world");
        String result = String.join(".", strs);
        System.out.println(result);
    }
}
