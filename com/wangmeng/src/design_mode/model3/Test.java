package design_mode.model3;

import design_mode.model3.absstactClass.Beverage;

public class Test {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();

        System.out.println(beverage.getDescription()
                + " $" + beverage.cost());

        System.out.println("------------------------");
        //装饰对象，装饰Espresso
        Beverage beverage2 = new Mocha(beverage);
        System.out.println(beverage2.getDescription()
                + " $" + beverage2.cost());

        System.out.println("------------------------");
        //装饰对象，装饰Mocha(加两份摩卡)
        Beverage beverage3 = new Mocha(beverage2);
        System.out.println(beverage3.getDescription()
                + " $" + beverage3.cost());

    }
}
