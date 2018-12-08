package com.example.elcy.appnutrientes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Tela3 extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtProteina;
    private TextView txtCarboidrato;
    private TextView txtGordura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceira_tela);

        final Intent intent = getIntent();

        txtNome = findViewById(R.id.txt_nome);
        txtProteina = findViewById(R.id.txt_proteina);
        txtCarboidrato = findViewById(R.id.txt_carboidrato);
        txtGordura = findViewById(R.id.txt_gordura);

        String nome =intent.getStringExtra("nome");
        txtNome.setText(nome);

        double cal = intent.getDoubleExtra("cal", 0);

        double proteina = cal * 0.15;
        double carboidrato = cal * 0.6;
        double gordura = cal * 0.25;

        String p = String.format("Proteína: %.0f calorias (%.0f gramas)", proteina,proteina/4);
        txtProteina.setText(p);
        String c = String.format("Carboidrato: %.0f calorias (%.0f gramas)", carboidrato,carboidrato/4);
        txtCarboidrato.setText(c);
        String g = String.format("Gordura: %.0f calorias (%.0f gramas)", gordura,gordura/9);
        txtGordura.setText(g);
    }

}

