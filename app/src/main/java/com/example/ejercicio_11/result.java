package com.example.ejercicio_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {
    TextView resultado, titulo;
    Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        assignValues();
        goBack.setOnClickListener(this::onClickBack);
    }

    protected void onClickBack(View view){
        Intent panel = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(panel);
    }

    private void assignValues(){
        Bundle bnd = getIntent().getExtras();
        resultado = findViewById(R.id.lblResultado);
        titulo = findViewById(R.id.lblTitulo);
        goBack = findViewById(R.id.btnRegresar);

        titulo.setText(bnd.getString("titulo"));
        resultado.setText(String.valueOf(bnd.getDouble("resultado")));
    }
}