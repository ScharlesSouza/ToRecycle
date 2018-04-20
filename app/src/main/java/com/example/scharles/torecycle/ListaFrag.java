package com.example.scharles.torecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        dataSource.add(new LixoItemLista("Dispositivos Moveis", "Silvano", "5"));
        dataSource.add(new LixoItemLista("Engenharia de Software", "Alex", "6"));
        dataSource.add(new LixoItemLista("Computação Gráfica", "Silvano", "4"));

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
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        LixoItemLista item = lista.get(position);

        holder.textoLixo.setText(item.material);
        holder.textoProfessor.setText(item.professor);
        holder.textoContador.setText(item.contador);
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
