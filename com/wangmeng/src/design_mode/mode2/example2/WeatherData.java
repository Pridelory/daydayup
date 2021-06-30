package design_mode.mode2.example2;

import java.util.Observable;

public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {}

    public void measurementsChanged() {
        //在调用notifuObservers()之前，要先调 用setChanged()来指示状态已经改变。
        setChanged();
        //我们没有调用 notifyObservers()传送数据对 象，这表示我们采用的做法是“拉”
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    //只是因为我们 要使用“拉”的做法，所以才提醒 你有这些方法。察者会利用这些方 法取得WeatherData对象的状态。
    public float getTemperature() { return temperature;
    }
    public float getHumidity() { return humidity;
    }
    public float getPressure() { return pressure;
    }
}
