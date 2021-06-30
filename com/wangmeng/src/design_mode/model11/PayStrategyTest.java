package design_mode.model11;

public class PayStrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1", "343432324323", 324.5);
        System.out.println(order.pay(PayStrategy.ALI_PAY));
    }
}
