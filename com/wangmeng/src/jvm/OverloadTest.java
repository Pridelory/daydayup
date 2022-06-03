package jvm;

/**
 * @ClassName OverloadTest
 * @Description 静态分派
 * @Author wangmeng
 * @Date 2022/5/21
 */
public class OverloadTest {

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        OverloadTest sr = new OverloadTest();
        sr.sayHello(man);
        sr.sayHello(woman);
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }
}
