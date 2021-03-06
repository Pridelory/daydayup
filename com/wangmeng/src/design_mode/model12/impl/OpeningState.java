package design_mode.model12.impl;

import design_mode.model12.abstractpackage.LiftState;
import design_mode.model12.context.Context;

public class OpeningState extends LiftState {
    @Override
    public void open() {
        System.out.println("电梯门已打开");
    }

    @Override
    public void close() {
        super.context.setLiftState(Context.closingState);
        super.context.getLiftState().close();
    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {
    }
}
