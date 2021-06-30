package design_mode.mode1.fly.impl;

import design_mode.mode1.fly.FlyBehavior;

/**
 * 不会飞
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can not fly");
    }
}
