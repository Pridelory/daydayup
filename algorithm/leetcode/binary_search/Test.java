package com.leetcode.binary_search;


/**
 * @ClassName Test
 * @Description TODO
 * @Author wangmeng
 * @Date 2021/3/31
 */
public class Test {
    public static void main(String[] args) {
        int month = 3;
        switch (month){
            case 1 | 2 | 3:
                System.out.println("是个5");
                break;
            case 4:
                System.out.println("是个4");
                break;
            default:
                System.out.println("默认值");
                break;
        }
    }
}
