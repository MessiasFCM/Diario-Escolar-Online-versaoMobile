package com.ifmg.diarioescolaronline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Ferramentas.EstudantesDB;
import Modelo.Estudante;

public class PerfilActivity extends AppCompatActivity {

    private TextView bNotaPorMateria, bHistorico, bSair, bAlterarSenha, tRegistroAcademico, tNomeEstudante, tEmailEstudante, tSenha, tSenhaConfirmar;
    private Estudante estudante=null;

    EstudantesDB db = new EstudantesDB(PerfilActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        bNotaPorMateria = (TextView)findViewById(R.id.tNotaPorMateria);
        bHistorico = (TextView)findViewById(R.id.tHistorico);
        bSair = (TextView)findViewById(R.id.tSair);
        bAlterarSenha = (TextView)findViewById(R.id.tAlterarSenha);

        tRegistroAcademico = (TextView)findViewById(R.id.tRegistroAcademico);
        tNomeEstudante = (TextView)findViewById(R.id.tNomeEstudante);
        tEmailEstudante = (TextView)findViewById(R.id.tEmailEstudante);
        tSenha = (TextView)findViewById(R.id.tSenha);
        tSenhaConfirmar = (TextView)findViewById(R.id.tSenhaConfirmar);

        Bundle dado = getIntent().getExtras();
        String idUsuario = dado.getString("RegistroAcademico");
        estudante = db.buscarEstudante(idUsuario);

        System.out.println("RA: " + estudante.getRegistroAcademico() + "Nome: " + estudante.getNomeEstudante() + "Email: " + estudante.getEmailEstudante()
                + "Senha: " + estudante.getSenhaEstudante());

        tRegistroAcademico.setText(estudante.getRegistroAcademico()+"");
        tNomeEstudante.setText(estudante.getNomeEstudante());
        tEmailEstudante.setText(estudante.getEmailEstudante());

        bNotaPorMateria.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(PerfilActivity.this, NotaSeparadaActivity.class);
                startActivity(it);
            }
        });

        bHistorico.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(PerfilActivity.this, NotaGeralActivity.class);
                startActivity(it);
            }
        });

        bAlterarSenha.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String senha1 = tSenha.getText().toString().trim();
                String senha2 = tSenhaConfirmar.getText().toString().trim();
                if(senha1.equals(senha2)){
                    System.out.println("RA: " + estudante.getRegistroAcademico() + "Nome: " + estudante.getNomeEstudante() + "Email: " + estudante.getEmailEstudante()
                            + "Senha: " + estudante.getSenhaEstudante());

                    estudante.setSenhaEstudante(senha1);
                    db.atualizarEstudante(estudante);
                    System.out.println("RA: " + estudante.getRegistroAcademico() + "Nome: " + estudante.getNomeEstudante() + "Email: " + estudante.getEmailEstudante()
                            + "Senha: " + estudante.getSenhaEstudante());

                    tSenha.setText(null);
                    tSenhaConfirmar.setText(null);
                }else{
                    System.out.println("Senhas não correspondidas");
                }
            }
        });

        bSair.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}