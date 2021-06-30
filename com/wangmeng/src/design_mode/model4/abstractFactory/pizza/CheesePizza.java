package design_mode.model4.abstractFactory.pizza;

import design_mode.model4.abstractFactory.PizzaAbasractFactory;

/**
 * 芝士披萨
 *
 * 通用
 */
public class CheesePizza extends Pizza{

    PizzaAbasractFactory pizzaAbasractFactory;

    public CheesePizza(PizzaAbasractFactory pizzaAbasractFactory) {
        this.pizzaAbasractFactory = pizzaAbasractFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing the " + name);
        dough = pizzaAbasractFactory.createDough();
        cheese = pizzaAbasractFactory.createCheese();
    }
}
