package design_mode.model4.abstractFactory.pizza;

import design_mode.model4.abstractFactory.sourceInterface.Cheese;
import design_mode.model4.abstractFactory.sourceInterface.Clam;
import design_mode.model4.abstractFactory.sourceInterface.Dough;
import design_mode.model4.abstractFactory.sourceInterface.Sauce;

/**
 * 披萨抽象类
 */
public abstract class Pizza {

    /**
     * 披萨的名称
     */
    String name;

    /**
     * 面团
     */
    Dough dough;

    /**
     * 酱料
     */
    Sauce sauce;

    /**
     * 芝士
     */
    Cheese cheese;

    /**
     * 蛤
     */
    Clam clam;

    //-----以下为准备披萨的步骤-----

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Placing the pizza in official box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
