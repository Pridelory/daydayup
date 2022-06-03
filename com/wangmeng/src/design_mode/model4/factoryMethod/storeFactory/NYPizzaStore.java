package design_mode.model4.factoryMethod.storeFactory;


import design_mode.model4.factoryMethod.pizza.NYStyleCheesePizza;
import design_mode.model4.factoryMethod.pizza.Pizza;

/**
 * 纽约披萨工厂
 */
public class NYPizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        }
        //以下省略
        return null;
    }
}
