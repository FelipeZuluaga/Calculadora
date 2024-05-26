package com.example.appcalculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TrigonometryActivity extends AppCompatActivity {

    private EditText etAngle;
    private Button btnSin;
    private Button btnCos;
    private Button btnTan;
    private Button btnBackToMenu;
    private TextView tvTrigResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigonometry);

        etAngle = findViewById(R.id.etAngle);
        btnSin = findViewById(R.id.btnSin);
        btnCos = findViewById(R.id.btnCos);
        btnTan = findViewById(R.id.btnTan);
        btnBackToMenu = findViewById(R.id.btnBackToMenu);
        tvTrigResult = findViewById(R.id.tvTrigResult);

        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTrigFunction("sin");
            }
        });

        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTrigFunction("cos");
            }
        });

        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTrigFunction("tan");
            }
        });

        btnBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calculateTrigFunction(String function) {
        String angleStr = etAngle.getText().toString();

        if (angleStr.isEmpty()) {
            Toast.makeText(this, "\n" + "Por favor introduce un ángulo", Toast.LENGTH_SHORT).show();
            return;
        }

        double angle = Double.parseDouble(angleStr);
        double result = 0;

        // Convert the angle to radians
        double angleRadians = Math.toRadians(angle);

        switch (function) {
            case "sin":
                result = Math.sin(angleRadians);
                break;
            case "cos":
                result = Math.cos(angleRadians);
                break;
            case "tan":
                result = Math.tan(angleRadians);
                break;
        }

        tvTrigResult.setText(String.format("%s: %f", function.toUpperCase(), result));
    }
}
