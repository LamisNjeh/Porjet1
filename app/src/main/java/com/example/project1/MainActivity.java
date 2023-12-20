package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private final Handler handler = new Handler(Looper.getMainLooper());
    private SimulatedIoTDevice simulatedIoTDevice;
    private Double temperature , humidity;
    Button button1 , button2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simulatedIoTDevice = new SimulatedIoTDevice();
        startFetchingData();

        button1 = findViewById(R.id.btn); // Replace with the actual ID of your button
            button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IrrigationActivity.class); // Replace OtherActivity1 with the actual name of your activity
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.button); // Replace with the actual ID of your button
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LightActivity.class); // Replace OtherActivity2 with the actual name of your activity
            startActivity(intent);
        });
    }
    private void startFetchingData() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateIoTDeviceData();
                handler.postDelayed(this, 4000);
            }
        }, 4000);
    }

    private void updateIoTDeviceData() {
        double temperature = simulatedIoTDevice.getTemperature();
        double humidity = simulatedIoTDevice.getHumidity();

        updateUI(temperature, humidity);
        writeToDatabase(temperature, humidity);
    }

    private void updateUI(double temperature, double humidity) {
        TextView temperatureTextView = findViewById(R.id.temp); // Replace with the actual ID of your TextView
        temperatureTextView.setText("Temperature: " + temperature + "°C");
        TextView humidityTextView = findViewById(R.id.humidity); // Replace with the actual ID of your TextView
        humidityTextView.setText("Humidity: " + humidity + "%");
    }

    private void writeToDatabase(double temperature, double humidity) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("iot-device-data");
            String data = "Temperature: " + temperature + "°C, Humidity: " + humidity + "%";
            myRef.push().setValue(data) ;
    }
}
