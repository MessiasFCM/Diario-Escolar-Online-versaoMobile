package com.ifmg.diarioescolaronline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotaGeralActivity extends AppCompatActivity {

    private TextView bVoltarTelaNotaGeral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_geral);

        bVoltarTelaNotaGeral = findViewById(R.id.bVoltarTelaNotaGeral);
        bVoltarTelaNotaGeral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}