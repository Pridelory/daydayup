package design_mode.model5.handlers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 处理动作类
 */
public class TimeHandler implements InvocationHandler {

    Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在被代理类处理前处理的事
        Long start = System.currentTimeMillis();
        System.out.println("计时准备..." + start);
        Thread.sleep(1000);

        //执行被代理类的方法
        Object obj = method.invoke(target);

        //在被代理类处理后处理的事
        Long end = System.currentTimeMillis();
        System.out.println("计时结束..." + end);
        System.out.println("花费时间："+ (end - start));
        return obj;
    }
}
