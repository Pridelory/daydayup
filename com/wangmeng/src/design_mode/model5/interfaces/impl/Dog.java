package design_mode.model5.interfaces.impl;

import design_mode.model5.interfaces.Animal;

public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("The dog is eating vegetables");
    }
}
