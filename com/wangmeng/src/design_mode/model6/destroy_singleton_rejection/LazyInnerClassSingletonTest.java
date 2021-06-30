package design_mode.model6.destroy_singleton_rejection;


import design_mode.model6.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射破坏单例
 */
public class LazyInnerClassSingletonTest {
    public static void main(String[] args) {
        // 获取LazyInnerClassSingleton类对应的Class类实例clazz
        Class<LazyInnerClassSingleton> clazz = LazyInnerClassSingleton.class;

        try {
            // 通过反射获取clazz的私有构造方法
            Constructor<LazyInnerClassSingleton> c = clazz.getDeclaredConstructor(null);
            // 强制访问
            c.setAccessible(true);

            // 相当于new 两次
            LazyInnerClassSingleton object1 = c.newInstance();
            LazyInnerClassSingleton object2 = c.newInstance();

            // false
            System.out.println(object1 == object2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 总结：
 * 可见，通过反射都可以破坏一般的单例
 * 解决 --> 在私有构造方法里检查，一旦创造了多次，那么直接抛出运行时异常。
 * 其实在私有构造方法里这么写的结果是即使第一次通过反射创建对象也不行，也就是禁用了反射。
 */
