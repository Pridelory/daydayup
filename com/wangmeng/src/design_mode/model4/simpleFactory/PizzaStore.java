package design_mode.model4.simpleFactory;

import design_mode.model4.simpleFactory.pizza.Pizza;

/**
 * 披萨商店
 */
public class PizzaStore {

    SimplePizzaFactory simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(String value) {
        Pizza pizza;

        pizza = SimplePizzaFactory.createPizza(value);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        pizza.getName();

        return pizza;
    }
}
