package design_mode.model4.factoryMethod.storeFactory;

import model4.factoryMethod.pizza.ChicagoStyleCheesePizza;
import model4.factoryMethod.pizza.Pizza;

/**
 * 芝加哥披萨工厂
 */
public class ChigagoPizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }
}
