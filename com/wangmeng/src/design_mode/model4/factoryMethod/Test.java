package design_mode.model4.factoryMethod;


import design_mode.model4.factoryMethod.pizza.Pizza;
import design_mode.model4.factoryMethod.storeFactory.NYPizzaStore;
import design_mode.model4.factoryMethod.storeFactory.PizzaStore;

public class Test {
    public static void main(String[] args) {
        PizzaStore pizzaStore1 = new NYPizzaStore();
        Pizza cheesePizza = pizzaStore1.orderPizza("cheese");
        System.out.println(cheesePizza.getName());
    }
}
