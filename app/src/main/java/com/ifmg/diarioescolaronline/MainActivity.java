package com.ifmg.diarioescolaronline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Ferramentas.EstudantesDB;
import Modelo.Estudante;

public class MainActivity extends AppCompatActivity {

    TextView bLogin, bCadastro, bTeste;
    EditText eUsuario,eSenha;
    String eUsuarioString, eSenhaString;

    EstudantesDB db = new EstudantesDB(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eUsuario = (EditText) findViewById(R.id.usuario);
        eSenha = (EditText)findViewById(R.id.senha);

        eUsuario.setText(null);
        eSenha.setText(null);

        bCadastro = (TextView)findViewById(R.id.cadastrarNovoEstudante);
        bCadastro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(it);
            }
        });

        bLogin = (TextView)findViewById(R.id.login);
        bLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buscarLogin();
            }
        });

        bTeste = (TextView) findViewById(R.id.teste);
        bTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int escolhaTeste = 1;
                if (escolhaTeste == 1) {
                    eUsuario = (EditText) findViewById(R.id.usuario);
                    eUsuarioString = eUsuario.getText().toString().trim();
                    Estudante teste = db.buscarEstudante(eUsuarioString);
                    if (teste != null) {
                        System.out.println("RA: " + teste.getRegistroAcademico() + "Nome: " + teste.getNomeEstudante() + "Email: " + teste.getEmailEstudante()
                                + "Senha: " + teste.getSenhaEstudante());
                    } else {
                        System.out.println("Não existe esse registro");
                    }
                } else {
                    System.out.println("escolha teste 2");
                }
            }
        });
    }

    private void buscarLogin(){
        eUsuario = (EditText) findViewById(R.id.usuario);
        eUsuarioString = eUsuario.getText().toString().trim();
        eSenha = (EditText) findViewById(R.id.senha);
        eSenhaString = eSenha.getText().toString().trim();

        System.out.println("Validação 1- " + eUsuarioString + " - " + eSenhaString);
        Estudante estudante = db.buscarEstudante(eUsuarioString);

        if(estudante != null) {
            System.out.println("Validação 2- " + estudante.getRegistroAcademico() + " - " + estudante.getSenhaEstudante() + " - " + estudante.getNomeEstudante());

            if (estudante.getSenhaEstudante().equals(eSenhaString)) {
                Intent it = new Intent(MainActivity.this, PerfilActivity.class);
                it.putExtra("RegistroAcademico", eUsuarioString);
                startActivity(it);
            } else {
                Toast.makeText(this, "Login ou senha incorreto", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Login inválido", Toast.LENGTH_SHORT).show();
        }
    }
}