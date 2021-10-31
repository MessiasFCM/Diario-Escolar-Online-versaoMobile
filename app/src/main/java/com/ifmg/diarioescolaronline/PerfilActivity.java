package com.ifmg.diarioescolaronline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    private TextView tNotaPorMateria,tHistorico, tSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tNotaPorMateria = (TextView)findViewById(R.id.tNotaPorMateria);
        tHistorico = (TextView)findViewById(R.id.tHistorico);
        tSair = (TextView)findViewById(R.id.tSair);

        tNotaPorMateria.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(PerfilActivity.this, NotaSeparadaActivity.class);
                startActivity(it);
            }
        });
        tHistorico.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(PerfilActivity.this, NotaGeralActivity.class);
                startActivity(it);
            }
        });
        tSair.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}