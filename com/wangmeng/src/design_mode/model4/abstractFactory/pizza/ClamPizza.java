package design_mode.model4.abstractFactory.pizza;

import design_mode.model4.abstractFactory.PizzaAbasractFactory;

/**
 * 蛤披萨
 */
public class ClamPizza extends Pizza{
    PizzaAbasractFactory pizzaAbasractFactory;

    public ClamPizza(PizzaAbasractFactory pizzaAbasractFactory) {
        this.pizzaAbasractFactory = pizzaAbasractFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing the " + name);
        clam = pizzaAbasractFactory.createClam();
    }
}
