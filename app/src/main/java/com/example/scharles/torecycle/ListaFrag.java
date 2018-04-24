package com.example.scharles.torecycle;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class ListaFrag extends Fragment {

    //private RecyclerView meuRecycleView;
    //private ArrayList<LixoItemLista> lista = null;

    ArrayList<LixoItemLista> dataSource = null;




    public ListaFrag() {
        // Required empty public constructor

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View viewFragment = inflater.inflate(R.layout.fragment_lista, null);




        dataSource = new ArrayList<>();
        RecyclerView lista = null;

        //Adicionando fixamente os itens, exemplo

        dataSource.add(new LixoItemLista("Papel"));
        dataSource.add(new LixoItemLista("Plástico"));
        dataSource.add(new LixoItemLista("Metal"));
        dataSource.add(new LixoItemLista("Vidro"));
        dataSource.add(new LixoItemLista("Orgânico"));
        dataSource.add(new LixoItemLista("Lixo não Reciclável"));
        dataSource.add(new LixoItemLista("Eletronico"));
        dataSource.add(new LixoItemLista("Hospitalar"));
        dataSource.add(new LixoItemLista("Entulho"));
        dataSource.add(new LixoItemLista("Doações"));


        lista = (RecyclerView)viewFragment.findViewById(R.id.listaPrincipal);
        lista.setLayoutManager(new LinearLayoutManager(getActivity()));
        lista.setItemAnimator(new DefaultItemAnimator());
        lista.setHasFixedSize(true);

        Adaptador adapt = new Adaptador(getActivity(), dataSource);
        lista.setAdapter(adapt);

        return viewFragment;

    }



}


class Adaptador extends RecyclerView.Adapter<ItemHolder>{

    Context contexto = null;
    ArrayList<LixoItemLista> lista = null;
    private AlertDialog alerta;

    Adaptador(Context contexto, ArrayList<LixoItemLista> lista){

        this.contexto = contexto;
        this.lista = lista;
    }

    //METODO CHAMADO N VEZES PARA INFLAR O XML DA CELULA E RETORNAR UM OBJETO DE LAYOUT
    /* Método que deverá retornar layout criado pelo ViewHolder já inflado em uma view. */
    //@NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.layout_lixo_item_lista, parent,false );
        ItemHolder item = new ItemHolder(celula);
        return item;
    }
    /*
     * Método que recebe o ViewHolder e a posição da lista.
     * Aqui é recuperado o objeto da lista de Objetos pela posição e associado à ViewHolder.
     * É onde a mágica acontece!
     * */
    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, final int position) {
        LixoItemLista item = lista.get(position);

        holder.textoMaterial.setText(item.material);

        holder.textoMaterial.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                contexto = view.getContext();
                Intent intent = new Intent(contexto, ActivityDetails.class);
                String posicao = Integer.toString(position);
                Log.d("posicao", posicao);
                intent.putExtra("Nome", lista.get(position).material);



                contexto.startActivity(intent);


            }
        });


        holder.textoMaterial.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
                builder.setTitle("Titulo");
                //define a mensagem
                builder.setMessage("Apagar " + lista.get(position).material);
                //define um botão como positivo
                builder.setPositiveButton("Apagar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        //NetworkUtils.Apagar(lista.get(position));
                        Toast.makeText(contexto, lista.get(position).material+" Apagada", Toast.LENGTH_SHORT).show();
                    }
                });
                //define um botão como negativo.
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
                //cria o AlertDialog
                alerta = builder.create();
                //Exibe
                alerta.show();
                return true;
            }

        });

    }


    //METODO QUE DETERMINA QUANTOS ITENS VAI TER NA LISTA
    /*
     * Método que deverá retornar quantos itens há na lista.
     * Aconselha-se verificar se a lista não está nula como no exemplo,
     * pois ao tentar recuperar a quantidade da lista nula pode gerar
     * um erro em tempo de execução (NullPointerException).
     * */
    @Override
    public int getItemCount() {

        return (lista != null)? lista.size() : 0;
    }


}
