package design_mode.model3;

import design_mode.model3.absstactClass.Beverage;

/**
 * 浓缩咖啡
 *
 * 饮料主体类 被装饰对象
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    //咖啡要1.99元
    public double cost() {
        return 1.99;
    }
}
