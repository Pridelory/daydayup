package design_mode.model4.abstractFactory.factoryImpl;

import design_mode.model4.abstractFactory.PizzaAbasractFactory;
import design_mode.model4.abstractFactory.sourceInterface.Cheese;
import design_mode.model4.abstractFactory.sourceInterface.Clam;
import design_mode.model4.abstractFactory.sourceInterface.Dough;
import design_mode.model4.abstractFactory.sourceInterface.Sauce;
import design_mode.model4.abstractFactory.sourceInterface.sourceImpl.FreshClam;
import design_mode.model4.abstractFactory.sourceInterface.sourceImpl.ThinCrustDough;

/**
 * 纽约原料工厂
 */
public class NYPizzaFactory implements PizzaAbasractFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return null;
    }

    @Override
    public Cheese createCheese() {
        return null;
    }

    @Override
    public Clam createClam() {
        return new FreshClam();
    }
}
