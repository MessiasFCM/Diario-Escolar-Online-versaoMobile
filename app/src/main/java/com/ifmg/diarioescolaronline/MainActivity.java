package com.ifmg.diarioescolaronline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView bLogin;
    EditText eUsuario,eSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eUsuario = (EditText) findViewById(R.id.usuario);
        eSenha = (EditText)findViewById(R.id.senha);
        bLogin = (TextView)findViewById(R.id.login);
        bLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(MainActivity.this, PerfilActivity.class);
                startActivity(it);
            }
        });
    }
}