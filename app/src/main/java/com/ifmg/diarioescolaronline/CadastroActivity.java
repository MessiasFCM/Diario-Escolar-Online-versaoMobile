package com.ifmg.diarioescolaronline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import Ferramentas.EstudantesDB;
import Modelo.Estudante;

public class CadastroActivity extends AppCompatActivity {
    TextView bVoltar, bCadastrar, usuarioCadastro, emailCadastro, senhaCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        EstudantesDB db = new EstudantesDB(CadastroActivity.this);

        usuarioCadastro = (TextView)findViewById(R.id.usuarioCadastro);
        emailCadastro = (TextView)findViewById(R.id.emailCadastro);
        senhaCadastro = (TextView)findViewById(R.id.senhaCadastro);

        bCadastrar = (TextView)findViewById(R.id.cadastrar);
        bCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuarioCadastro != null && emailCadastro != null && senhaCadastro != null){
                    Estudante estudante = new Estudante(usuarioCadastro.getText().toString().trim(),emailCadastro.getText().toString().trim(),senhaCadastro.getText().toString().trim());
                    db.inserirEstudante(estudante);
                    System.out.println("RA: " + estudante.getRegistroAcademico() + " Nome: " + estudante.getNomeEstudante() + " Email: " + estudante.getEmailEstudante()
                            + " Senha: " + estudante.getSenhaEstudante());
                    finish();
                }else{
                    System.out.println("Dados não preenchidos");
                }
            }
        });

        bVoltar = (TextView)findViewById(R.id.voltar);
        bVoltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}