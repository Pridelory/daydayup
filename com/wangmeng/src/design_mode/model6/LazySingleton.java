package design_mode.model6;

/**
 * 单例-懒汉模式
 */
public class LazySingleton {

    private static LazySingleton uniqueInstance;

    // 私有构造方法
    // 只能在本类调用构造Singleton对象
    private LazySingleton() {}

    // 静态 直接通过类名调用
    // 保险起见加上synchronized关键字
    public synchronized static LazySingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new LazySingleton();
        }
        return uniqueInstance;
    }
}

/**
 * 总结：
 * 懒汉式在该类实例用到的时候才会进行初始化对象进内存，比较节省内存。
 * 但会存在线程安全问题，特此在getInstance()方法上加上synchronized关键字。
 * 解决了线程安全问题又会导致程序性能降低，更好的解决方案请看 --> LazyInnerClassSingleton类
 */
