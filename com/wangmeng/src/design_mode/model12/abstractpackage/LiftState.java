package design_mode.model12.abstractpackage;

import design_mode.model12.context.Context;

/**
 * 电梯状态抽象类
 */
public abstract class LiftState {
    public Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * 电梯开门
     */
    public abstract void open();

    /**
     * 电梯关门
     */
    public abstract void close();

    /**
     * 电梯运行
     */
    public abstract void run();

    /**
     * 电梯停止
     */
    public abstract void stop();
}
