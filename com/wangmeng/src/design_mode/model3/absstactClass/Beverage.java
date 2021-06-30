package design_mode.model3.absstactClass;

/**
 * 饮料抽象类
 */
public abstract class Beverage {

    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
