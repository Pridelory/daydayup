package design_mode.model4.abstractFactory.pizzaStore;

import design_mode.model4.abstractFactory.PizzaAbasractFactory;
import design_mode.model4.abstractFactory.factoryImpl.NYPizzaFactory;
import design_mode.model4.abstractFactory.pizza.ClamPizza;
import design_mode.model4.abstractFactory.pizza.Pizza;

/**
 * 纽约披萨店
 */
public class NYPizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaAbasractFactory pizzaAbasractFactory =
                new NYPizzaFactory();
        if (type.equals("clam")) {
            pizza = new ClamPizza(pizzaAbasractFactory);
            pizza.setName("New York Style Clam Pizza");
        }
        return pizza;
    }
}
