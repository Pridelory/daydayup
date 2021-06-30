package design_mode.mode1.fly.impl;

import design_mode.mode1.fly.FlyBehavior;

/**
 * 用翅膀飞
 * 实现类
 */
public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I am flying with wings");
    }
}
