package com.example.appcalculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AlgebraActivity extends AppCompatActivity {

    private EditText etCoefficientA;
    private EditText etCoefficientB;
    private Button btnSolveEquation;
    private Button btnBackToMenu;
    private TextView tvAlgebraResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algebra);

        etCoefficientA = findViewById(R.id.etCoefficientA);
        etCoefficientB = findViewById(R.id.etCoefficientB);
        btnSolveEquation = findViewById(R.id.btnSolveEquation);
        btnBackToMenu = findViewById(R.id.btnBackToMenu);
        tvAlgebraResult = findViewById(R.id.tvAlgebraResult);

        btnSolveEquation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solveEquation();
            }
        });

        btnBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void solveEquation() {
        String aStr = etCoefficientA.getText().toString();
        String bStr = etCoefficientB.getText().toString();

        if (aStr.isEmpty() || bStr.isEmpty()) {
            Toast.makeText(this, "Por favor introduzca ambos coeficientes", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);

        if (a == 0) {
            Toast.makeText(this, "El coeficiente a no puede ser cero.", Toast.LENGTH_SHORT).show();
            return;
        }

        double result = -b / a;
        tvAlgebraResult.setText(String.format("x = %f", result));
    }
}
