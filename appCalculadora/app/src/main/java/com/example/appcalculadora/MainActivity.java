package com.example.appcalculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.equals("admin") && password.equals("1234")) {
                    Toast.makeText(MainActivity.this, "INICIO SESIÓN CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Bienvenida.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "USER Y PASS SON INCORRECTOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
