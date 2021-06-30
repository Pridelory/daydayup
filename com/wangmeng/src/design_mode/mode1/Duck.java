package design_mode.mode1;

import design_mode.mode1.fly.FlyBehavior;

/**
 * 鸭子抽象类
 */
public abstract class Duck {

    FlyBehavior flyBehavior;

    /**
     * 鸭子的展示（颜色等）
     * 不同子类定义自己的展示
     */
    public abstract void display();

    /**
     * 鸭子游泳
     * 通用不变的功能
     */
    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    /**
     * 鸭子飞功能
     * 委托行为给FlyBehavior这个类
     */
    public void performFly() {
        flyBehavior.fly();
    }

    /**
     * 动态地设置鸭子的飞行功能（运行时设置 没有写死）
     * @param flyBehavior
     */
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
