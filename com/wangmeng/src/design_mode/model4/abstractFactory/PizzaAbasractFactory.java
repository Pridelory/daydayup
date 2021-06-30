package design_mode.model4.abstractFactory;

import design_mode.model4.abstractFactory.sourceInterface.Cheese;
import design_mode.model4.abstractFactory.sourceInterface.Clam;
import design_mode.model4.abstractFactory.sourceInterface.Dough;
import design_mode.model4.abstractFactory.sourceInterface.Sauce;

/**
 * 原料抽象工厂
 */
public interface PizzaAbasractFactory {

    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Clam createClam();
}
