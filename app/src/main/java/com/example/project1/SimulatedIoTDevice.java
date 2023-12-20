package com.example.project1;

import java.util.Random;

public class SimulatedIoTDevice {

    private double temperature = 25.0;
    private double humidity = 50.0;

    public double getTemperature() {
        simulateSensorData();
        return temperature;
    }

    public double getHumidity() {
        simulateSensorData();
        return humidity;
    }

    private void simulateSensorData() {
        // Simulate changes in temperature and humidity for demonstration purposes
        Random random = new Random();
        temperature = 25.0*random.nextDouble()  ; // Random value between -1.0 and 1.0
        humidity =25.0* random.nextDouble()  ;    // Random value between -1.0 and 1.0
        // Ensure temperature and humidity stay within a reasonable range
        temperature = Math.max(0.0, Math.min(100.0, temperature));
        humidity = Math.max(0.0, Math.min(100.0, humidity));
    }
}
