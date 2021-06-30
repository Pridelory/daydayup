package design_mode.model5.interfaces.impl;

import design_mode.model5.interfaces.Moveable;

/**
 * 坦克类
 * 被代理的类
 */
public class Tank implements Moveable {

    @Override
    public void move() {
        System.out.println("hong hong hong hong");
    }
}
