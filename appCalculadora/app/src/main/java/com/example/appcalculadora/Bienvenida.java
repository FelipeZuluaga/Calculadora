package com.example.appcalculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Bienvenida extends AppCompatActivity {

    private ListView listViewMenu;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        listViewMenu = findViewById(R.id.listViewMenu);
        btnLogout = findViewById(R.id.btnLogout);

        String[] menuItems = {
                "Algebra",
                "Calculo",
                "Química",
                "Trigonometría",
                "Foto",
                "Calculadora básica"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menuItems);
        listViewMenu.setAdapter(adapter);

        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(Bienvenida.this, selectedItem, Toast.LENGTH_SHORT).show();

                Intent intent = null;
                switch (selectedItem) {
                    case "Algebra":
                        intent = new Intent(Bienvenida.this, AlgebraActivity.class);
                        break;
                    case "Trigonometría":
                        intent = new Intent(Bienvenida.this, TrigonometryActivity.class);
                        break;
                    case "Calculadora básica":
                        intent = new Intent(Bienvenida.this, CalculatorActivity.class);
                        break;
                    // Agrega más casos según sea necesario para otras opciones
                }

                if (intent != null) {
                    startActivity(intent);
                }
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bienvenida.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}


