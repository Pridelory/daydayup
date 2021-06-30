package design_mode.model4.simpleFactory;


import design_mode.model4.simpleFactory.pizza.Pizza;

public class Test {
    public static void main(String[] args) {
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(simplePizzaFactory);
        Pizza pizza = pizzaStore.orderPizza("clam");
        System.out.println(pizza.getName());
    }
}
