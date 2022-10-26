package com.example.ejercicio_11;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio_11.OpeMat.MAT;

public class MainActivity extends AppCompatActivity {
    EditText value1, value2;
    Button suma, resta, mult, div, salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignValues();

        suma.setOnClickListener(this::onClickSuma);
        resta.setOnClickListener(this::onClickResta);
        mult.setOnClickListener(this::onClickMultiplicacion);
        div.setOnClickListener(this::onClickDivision);
        salir.setOnClickListener(this::onClickSalir);
    }

    protected void onClickSuma(View view){
        if(!emptyField(value1, value2)){
            MAT mt = new MAT (Integer.parseInt(value1.getText().toString()), Integer.parseInt(value2.getText().toString()));
            openActivity("RESULTADO DE LA SUMA", mt.suma());
        }else message("Hay campos vacios");
    }

    protected void onClickResta(View view){
        if(!emptyField(value1, value2)) {
            MAT mt = new MAT(Integer.parseInt(value1.getText().toString()), Integer.parseInt(value2.getText().toString()));
            openActivity("RESULTADO DE LA RESTA", mt.resta());
        }else message("Hay campos vacios");
    }

    protected void onClickMultiplicacion(View view){
        if(!emptyField(value1, value2)) {
            MAT mt = new MAT(Integer.parseInt(value1.getText().toString()), Integer.parseInt(value2.getText().toString()));
            openActivity("RESULTADO DE LA MULTIPLICACIÓN", mt.multiplicacion());
        }else message("Hay campos vacios");
    }

    protected void onClickDivision(View view){
        if(!emptyField(value1, value2)) {
            MAT mt = new MAT(Integer.parseInt(value1.getText().toString()), Integer.parseInt(value2.getText().toString()));
            openActivity("RESULTADO DE LA DIVISIÓN", mt.division());
        }else message("Hay campos vacios");
    }

    protected void onClickSalir(View view){
        AlertDialog dialogo = new AlertDialog.Builder(MainActivity.this).setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onDestroy();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setTitle("Salir").setMessage("¿Deseas salir de la aplicación?").create();
        dialogo.show();
        System.exit(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    protected void openActivity(String titulo, Double resultado){
        Intent panel = new Intent(getApplicationContext(), result.class);
        Bundle bnd = new Bundle();
        bnd.putDouble("resultado", resultado);
        bnd.putString("titulo", titulo);
        panel.putExtras(bnd);
        startActivity(panel);
    }

    private void assignValues(){
        value1 = findViewById(R.id.txtValue1);
        value2 = findViewById(R.id.txtValue2);
        suma = findViewById(R.id.btnSumar);
        resta = findViewById(R.id.btnRestar);
        mult = findViewById(R.id.btnMult);
        div = findViewById(R.id.btnDiv);
        salir = findViewById(R.id.btnSalir);
    }

    protected boolean emptyField(EditText v1, EditText v2){
        if (v1.getText().toString().length() < 1 || v2.getText().toString().length() < 1) return true;
        else return false;
    }

    private void message(String msg){
        Toast.makeText(this, msg, LENGTH_SHORT).show();
    }


}