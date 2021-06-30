package design_mode.mode2.example1;


import design_mode.mode2.GeneralInterface.Observer;
import design_mode.mode2.GeneralInterface.Subject;

import java.util.ArrayList;

/**
 * 气象站主题（数据发送者）
 */
public class WeatherData implements Subject {

    /**
     * 观察者
     */
    private ArrayList<Observer> observers;

    //气象站设备获取的相关参数
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        //......
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(temperature, humidity, pressure);
        }
    }

    /**
     * 气象站数据变动接口
     * 接口改变就通知全部观察者
     */
    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
