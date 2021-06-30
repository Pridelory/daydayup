package design_mode.model4.imitateSpringFactory.example;

import java.util.Properties;

/**
 * 测试类
 *
 * 装在配置文件
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(Test.class.getClassLoader().getResourceAsStream("model4/imitateSpringFactory/example/moveable.properties"));
        String vehicleName = properties.getProperty("Vehicle");
        //反射
        Object object = Class.forName(vehicleName).newInstance();
        Moveable moveable = (Moveable) object;
        moveable.run();
    }
}

/**
 * 1、利用运行时动态加载配置文件可实现面向接口编程以及极大降低代码的耦合，代码不再写死。
 * 2、这里用到了反射技术，注意Class.forName(String name)这里的name是the fully qualified name of the desired class.全限定名
 * 3、
 */