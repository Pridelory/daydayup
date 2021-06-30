package design_mode.model4.factoryMethod.storeFactory;

import model4.factoryMethod.pizza.Pizza;

/**
 * pizza工厂的抽象类
 */
public abstract class PizzaStore {

    Pizza pizza;

    public Pizza orderPizza(String type) {

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    /**
     * 创建pizza抽象方法
     *
     * 将创建实例推迟到子类完成
     * @param type
     * @return
     */
    protected abstract Pizza createPizza(String type);

    //可定义多个抽象方法........
}
