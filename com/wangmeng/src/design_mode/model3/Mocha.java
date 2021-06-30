package design_mode.model3;

import design_mode.model3.absstactClass.Beverage;
import design_mode.model3.absstactClass.CondimentDecorator;

/**
 * 摩卡配料
 *
 * 装饰者
 */
public class Mocha extends CondimentDecorator {

    //把被装饰者传入
    //组件组合
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
