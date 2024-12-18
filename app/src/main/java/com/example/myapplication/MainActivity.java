package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button colorButton;
    private int pressCount = 0;
    private boolean isBlue = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorButton = findViewById(R.id.colorButton);
        colorButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));

        colorButton.setOnClickListener(v -> {
            pressCount++;
            toggleButtonColor();
            updateButtonText();
        });
    }

    private void toggleButtonColor() {
        if (isBlue) {
            colorButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        } else {
            colorButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));
        }
        isBlue = !isBlue;
    }

    private void updateButtonText() {
        if (pressCount == 5) {
            colorButton.setText(getString(R.string.button_ouch));
        } else if (pressCount == 10) {
            int randomNumber = new Random().nextInt(100) + 1;
            colorButton.setText(String.valueOf(randomNumber));
        }
    }
}