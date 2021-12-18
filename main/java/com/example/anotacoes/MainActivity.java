package com.example.anotacoes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacoesPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);

        preferencias = new AnotacoesPreferencias(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String textoReculperado=editAnotacao.getText().toString();
                if(textoReculperado.equals("")){
                    Snackbar.make(view, "Preencha anotação", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    preferencias.salvarAnotacoes(textoReculperado);
                    Snackbar.make(view, "Texto salvo", Snackbar.LENGTH_LONG).show();
                }


            }
        });

        String anotacao = preferencias.recuperarAnotacao();
        if (!anotacao.equals("")){
            editAnotacao.setText(anotacao);
        }

    }

}
