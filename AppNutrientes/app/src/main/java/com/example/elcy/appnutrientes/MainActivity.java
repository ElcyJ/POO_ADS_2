package com.example.elcy.appnutrientes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static java.lang.String.format;

public class MainActivity extends AppCompatActivity {

    public static final String NOME = "nome";
    public static final int REQUEST_CODE = 1001;
    EditText editNome;
    Button btnDados;
    String nome = "";
    TextView txtTmb;
    TextView txtDados;
    TextView txtGet;
    RadioGroup radio;
    Button btnDetalhes;
    double tmb;
    String g;
    double cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.edit_nome);
        btnDados = findViewById(R.id.btn_dados);
        txtTmb = findViewById(R.id.txt_tmb);
        txtDados = findViewById(R.id.txt_dados);
        txtGet = findViewById(R.id.txt_get);
        radio = findViewById(R.id.radio);
        btnDetalhes = findViewById(R.id.btn_detalhes);
    }

    public void irParaTela2(View view) {

        nome = editNome.getText().toString();

        final Intent intent = new Intent(this, Tela2.class);
        intent.putExtra(NOME, nome);

        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {

            if (resultCode == RESULT_OK) {

                tmb = data.getDoubleExtra(Tela2.DADOS, 0.0);
                double altura = data.getDoubleExtra("altura", 0);
                double peso = data.getDoubleExtra("peso", 0);

                txtDados.setText(format("Altura: %.1f  Peso: %.1f", altura, peso));
                txtDados.setVisibility(View.VISIBLE);
                txtTmb.setText(format("%s, seu TMB é %.2f", nome, tmb));
                txtTmb.setVisibility(View.VISIBLE);
                radio.setVisibility(View.VISIBLE);

                editNome.getText().clear();

            }

        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        double get = tmb;

        switch(view.getId()) {
            case R.id.radio_sed:
                if (checked)
                    cal = get;
                    g = String.format("GET: %.2f", get);
                    txtGet.setText(g);
                    txtGet.setVisibility(View.VISIBLE);
                    btnDetalhes.setVisibility(View.VISIBLE);
                    break;
            case R.id.radio_lev_ativo:
                if (checked)
                    cal = get * 1.11;
                    g = String.format("GET: %.2f", get * 1.11);
                    txtGet.setText(g);
                    txtGet.setVisibility(View.VISIBLE);
                    btnDetalhes.setVisibility(View.VISIBLE);
                    break;
            case R.id.radio_mod_ativo:
                if (checked)
                    cal = get * 1.25;
                    g = String.format("GET: %.2f", get * 1.25);
                    txtGet.setText(g);
                    txtGet.setVisibility(View.VISIBLE);
                    btnDetalhes.setVisibility(View.VISIBLE);
                    break;
            case R.id.radio_muito_ativo:
                if (checked)
                    cal = get * 1.48;
                    g = String.format("GET: %.2f", get * 1.48);
                    txtGet.setText(g);
                    txtGet.setVisibility(View.VISIBLE);
                    btnDetalhes.setVisibility(View.VISIBLE);
                    break;
        }
    }

    public void detalhar(View view) {

        Intent intent = new Intent(this, Tela3.class);
        intent.putExtra("nome", nome);
        intent.putExtra("cal", cal);

        startActivity(intent);
    }
}

