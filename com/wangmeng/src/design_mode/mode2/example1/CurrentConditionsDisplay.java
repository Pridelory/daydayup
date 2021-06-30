package design_mode.mode2.example1;

import design_mode.mode2.GeneralInterface.DisplayElement;
import design_mode.mode2.GeneralInterface.Observer;
import design_mode.mode2.GeneralInterface.Subject;

/**
 * 告布板 -- 当前天气
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement {

    private float temperature;
    private float humidity;

    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
