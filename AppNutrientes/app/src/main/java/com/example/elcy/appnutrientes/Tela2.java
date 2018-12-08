package com.example.elcy.appnutrientes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Tela2 extends AppCompatActivity {

    public static final String DADOS = "dados";
    private EditText editPeso;
    private EditText editAltura;
    private Button btnFinalizar;
    private TextView txtNome;
    private Double TMB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_tela);

        final Intent intent = getIntent();

        String nome = intent.getStringExtra(MainActivity.NOME);
        txtNome = findViewById(R.id.txt_nome);
        txtNome.setText("Olá " + nome);

        editAltura = findViewById(R.id.edit_altura);
        editPeso = findViewById(R.id.edit_peso);
        btnFinalizar = findViewById(R.id.btn_finalizar);

    }

    public void mandarDados(View view) {

        double altura = Double.parseDouble(editAltura.getText().toString());
        double peso = Double.parseDouble(editPeso.getText().toString());

        TMB = ((11.3 * peso) + (16 * altura)) + 901;

        final Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(DADOS, TMB);
        intent.putExtra("peso", peso);
        intent.putExtra("altura", altura);

        setResult(RESULT_OK, intent);
        //startActivity(intent);
        finish();
    }


}
