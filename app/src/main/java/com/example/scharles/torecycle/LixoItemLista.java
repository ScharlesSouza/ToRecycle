package com.example.scharles.torecycle;

import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

class ItemHolder extends RecyclerView.ViewHolder {

    TextView textoLixo = null;
    TextView textoProfessor = null;
    TextView textoContador = null;



    ItemHolder(View view){
        super(view);

        textoLixo = (TextView)view.findViewById(R.id.textViewDisc);
        textoProfessor = (TextView)view.findViewById(R.id.textViewProf);
        textoContador = (TextView)view.findViewById(R.id.textViewCont);

    }
}

public class LixoItemLista {
    String material;
    String professor;
    String contador;

    LixoItemLista( String sMaterial, String sProfessor, String sContador){

        material = sMaterial;
        professor = sProfessor;
        contador = sContador;

    }

}
