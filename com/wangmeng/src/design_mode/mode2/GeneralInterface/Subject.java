package design_mode.mode2.GeneralInterface;

/**
 * 主题
 * 观察者模式中的主题
 */
public interface Subject {

    /**
     * 注册观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();
}
