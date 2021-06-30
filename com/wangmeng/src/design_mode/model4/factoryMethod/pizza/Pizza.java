package design_mode.model4.factoryMethod.pizza;


/**
 * 披萨抽象类
 */
public abstract class Pizza {

    /**
     * 披萨的名称
     */
    String name;

    /**
     * 面s团
     */
    String dough;

    /**
     * 酱料
     */
    String sauce;

    //-----以下为准备披萨的步骤-----

    public void prepare() {
        System.out.println("Preparing the pizza: "+ this.name);
        System.out.println("Tossing the " + this.dough);
        System.out.println("Adding the " + this.sauce);
    }

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
}
