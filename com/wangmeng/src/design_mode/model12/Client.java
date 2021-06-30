package design_mode.model12;

import design_mode.model12.context.Context;
import design_mode.model12.impl.ClosingState;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
