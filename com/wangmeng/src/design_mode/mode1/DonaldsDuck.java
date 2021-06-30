package design_mode.mode1;

import design_mode.mode1.fly.impl.FlyNoWay;

/**
 * 唐老鸭
 * 实现了鸭子抽象类
 */
public class DonaldsDuck extends Duck {

    public DonaldsDuck() {
        //一开始都不会飞
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("I’m a real Donalds duck");
    }
}
