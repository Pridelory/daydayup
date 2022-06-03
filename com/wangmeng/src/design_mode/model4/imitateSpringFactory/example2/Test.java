//package design_mode.model4.imitateSpringFactory.example2;
//
///**
// * 测试类
// *
// */
//public class Test {
//
//    public static void main(String[] args) throws Exception {
//       BeanFactory factory = new ClassPathXmlApplicationContext("model4/imitateSpringFactory/example2/applicationContext.xml");
//       Object bean = factory.getBean("vehicle");
//       Moveable moveable = (Moveable) bean;
//       moveable.run();
//    }
//}
//
///**
// * 用Spring实现工厂
// * 其实Spring也就是把XML中的信息读出并且转化为键值对存放到Spring维护的一个map里，
// * 这个map就相当于所谓的容器，取对象就是根据id取map，然后利用反射得出类的实例。
// */