package design_mode.mode1;

import design_mode.mode1.fly.impl.FlyWithWings;

public class Test {
    public static void main(String[] args) {
        DonaldsDuck donaldsDuck = new DonaldsDuck();
        donaldsDuck.performFly();
        //动态地让鸭子实现飞的功能
        donaldsDuck.setFlyBehavior(new FlyWithWings());
        donaldsDuck.performFly();
//        donaldsDuck.display();
//        donaldsDuck.swim();
    }
}
