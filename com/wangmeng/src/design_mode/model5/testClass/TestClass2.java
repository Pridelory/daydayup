package design_mode.model5.testClass;

import design_mode.model5.interfaces.impl.Tank;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass2 {
    public static void main(String[] args) {
//        Tank tank = new Tank();
//        Class<? extends Tank> aClass = tank.getClass();
//        System.out.println(aClass.toString());
        try {
            Class<?> aClass = Class.forName("model5.interfaces.impl.Tank");
            Method m = aClass.getMethod("move");
            m.invoke(new Tank());
            Object o = aClass.newInstance();
            Tank tank = (Tank)o;
//            tank.move();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
