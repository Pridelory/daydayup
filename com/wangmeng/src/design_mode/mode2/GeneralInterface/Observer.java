package design_mode.mode2.GeneralInterface;

/**
 * 观察者
 */
public interface Observer {

    /**
     * 更新观察者
     * 所有观察者必须实现的方法
     * 主题只知道观察者实现了该方法从而对其进行更新
     */
    void update(float temp, float humidity, float pressure);
}
