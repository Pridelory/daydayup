package design_mode.model4.abstractFactory.factoryImpl;

import design_mode.model4.abstractFactory.PizzaAbasractFactory;
import design_mode.model4.abstractFactory.sourceInterface.Cheese;
import design_mode.model4.abstractFactory.sourceInterface.Clam;
import design_mode.model4.abstractFactory.sourceInterface.Dough;
import design_mode.model4.abstractFactory.sourceInterface.Sauce;
import design_mode.model4.abstractFactory.sourceInterface.sourceImpl.FrozenClam;
import design_mode.model4.abstractFactory.sourceInterface.sourceImpl.ThickCrustDough;

/**
 * 芝加哥原料工厂
 */
public class ChicagoPizzaFactory implements PizzaAbasractFactory {

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
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
        return new FrozenClam();
    }
}
