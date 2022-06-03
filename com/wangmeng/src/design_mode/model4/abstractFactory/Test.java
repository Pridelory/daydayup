package design_mode.model4.abstractFactory;

import design_mode.model4.abstractFactory.pizza.Pizza;
import design_mode.model4.abstractFactory.pizzaStore.ChicagoPizzaStore;
import design_mode.model4.abstractFactory.pizzaStore.NYPizzaStore;
import design_mode.model4.abstractFactory.pizzaStore.PizzaStore;

public class Test {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza pizza = nyPizzaStore.orderPizza("clam");
        System.out.println(pizza.getName());
        System.out.println("-------------------------");
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        Pizza pizza1 = chicagoPizzaStore.orderPizza("clam");
        System.out.println(pizza1.getName());
    }
}
