package design_mode.model6;

/**
 * 用静态内部类实现单例
 */
public class LazyInnerClassSingleton {

    // 如果没有使用，内部类是不加载的
    private LazyInnerClassSingleton() {
        // 以下三行代码请阅读过destroy_singleton_rejection后再关注
        // 作用是防止通过反射破坏单例模式
        if (LazyHolder.LZAY != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public static final  LazyInnerClassSingleton getInstance() {
        return LazyHolder.LZAY;
    }

    // 默认不加载
    private static class LazyHolder {
        private static final LazyInnerClassSingleton LZAY = new LazyInnerClassSingleton();
    }
}

/**
 * 总结：
 * 在最初加载类的时候LazyHolder默认不加载，这也就解决了 --> 类实例提前加载占内存的问题。
 * 同时，一旦此类实例加载好并且被LAZY指向了，则以后就直接范围实例，也就是说"只创建一次"解决了 --> 并发问题
 */
