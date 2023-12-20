package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LightActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.light); // Replace with the actual name of your XML layout file
        // Your additional code for the IrrigationActivity
        Button buttonBackToMain = findViewById(R.id.home1);

        buttonBackToMain.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    // Create an Intent to start the MainActivity
                                                    Intent intent = new Intent(LightActivity.this, MainActivity.class);
                                                    startActivity(intent);
                                                }
                                            }
        );
    }
}
