package design_mode.model12.context;

import design_mode.model12.abstractpackage.LiftState;
import design_mode.model12.impl.ClosingState;
import design_mode.model12.impl.OpeningState;
import design_mode.model12.impl.RunningState;
import design_mode.model12.impl.StoppingState;

public class Context {

    // 通过Context把各个状态暴露出去
    public static final OpeningState openingState = new OpeningState();
    public static final ClosingState closingState = new ClosingState();
    public static final RunningState runningState = new RunningState();
    public static final StoppingState stoppingState = new StoppingState();

    private LiftState liftState;

    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }
}
