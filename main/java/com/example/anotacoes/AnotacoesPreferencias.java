package com.example.anotacoes;

import android.content.Context;
import android.content.SharedPreferences;
import android.print.PrinterId;

public class AnotacoesPreferencias {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String NOME_ARQUIVO="arquivo.preferencia";
    private final String CHAVE_NOME="nome";

    public AnotacoesPreferencias(Context c) {
        this.context=c;
        preferences= context.getSharedPreferences(NOME_ARQUIVO,0);
        editor=preferences.edit();
    }

    public void salvarAnotacoes(String anotacao){
        editor.putString(CHAVE_NOME,anotacao);
        editor.commit();
    }
    public String recuperarAnotacao(){
        return preferences.getString(CHAVE_NOME,"");
    }

}
