package design_mode.model8.interfaces.Impl;


import design_mode.model8.interfaces.Turkey;

/**
 * 火鸡实现类
 */
public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("Gobble goobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
