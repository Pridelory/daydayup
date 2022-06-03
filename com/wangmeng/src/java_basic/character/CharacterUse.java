package java_basic.character;

import java.util.ArrayList;

/**
 * @ClassName CharacterUse
 * @Description 整理一些Character类的常用方法
 * @Author wangmeng
 * @Date 2021/7/19
 */
public class CharacterUse {
    public static void main(String[] args) {
        // 将字符转为大小写字符
        char c = 'A';
        // 转为小写
        System.out.println(Character.toLowerCase(c));
        // 转为大写
        System.out.println(Character.toUpperCase(c));
        // 判断字符是否是数字
        System.out.println(Character.isDigit(c));
        // 判断字符是否是字母
        System.out.println(Character.isLetter(c));
        // 判断字符是否是"数字或字母"
        System.out.println(Character.isLetterOrDigit(c));
    }
}
