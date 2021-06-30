package design_mode.model6;

/**
 * 单例设计模式--饿汉式
 */
public class HungrySingleton {

    private static HungrySingleton uniqueInstance = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getUniqueInstance() {
        return uniqueInstance;
    }
}

/**
 * 总结：
 * 饿汉式在类加载时就立刻初始化，并且创建单例对象。
 * 特点是绝对的线程安全，不存在访问安全问题
 *
 * 优点：线程安全且没有任何锁，执行效率高。
 * 缺点：类加载时候就初始化，用或不用都占内存，可能占着茅坑不拉屎
 */
