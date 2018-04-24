package com.example.scharles.torecycle;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroFrag extends Fragment {

    Spinner spinnerMaterial;
    Button btnCadastro;
    EditText descricaoCadastro;
    EditText localizacaoCadastro;



    public CadastroFrag() {
        // Required empty public constructor

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFragment = inflater.inflate(R.layout.fragment_cadastro, null);

        spinnerMaterial = (Spinner) viewFragment.findViewById(R.id.SpinnerMaterial);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.ListaMaterial, android.R.layout.simple_spinner_item);
        spinnerMaterial.setAdapter(adapter);


        descricaoCadastro = (EditText)getActivity().findViewById(R.id.DescricaoCadastro);
        localizacaoCadastro = (EditText)getActivity().findViewById(R.id.localizacaoCadastro);


        // Chama a tela Cadastro Esvento
        btnCadastro = (Button ) viewFragment.findViewById ( R.id.btnCadastrar);
        btnCadastro.setOnClickListener ( new View.OnClickListener(){

            @Override
            public void onClick(View view) {




            }
        });


        return viewFragment;

    }

    public Boolean cadastraDoacao(){




        return false;


    }


}