package design_mode.model5.testClass;

/**
 * Class类测试
 */
public class TestClass {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("java.lang.String");
            System.out.println();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
