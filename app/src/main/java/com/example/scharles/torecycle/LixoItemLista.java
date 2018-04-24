package com.example.scharles.torecycle;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

class ItemHolder extends RecyclerView.ViewHolder {


    TextView textoMaterial = null;


    ItemHolder(View view){
        super(view);

        textoMaterial = (TextView)view.findViewById(R.id.textViewMaterial);


    }
}

public class LixoItemLista {
    String material;
    String cor;




    LixoItemLista( String sMaterial){

        material = sMaterial;


    }



}
