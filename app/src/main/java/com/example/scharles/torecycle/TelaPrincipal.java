package com.example.scharles.torecycle;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class TelaPrincipal extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        //setFragment(new ListaFrag());
        //setFragment(new Fragment());

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);


    }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentmanager = getSupportFragmentManager();
            FragmentTransaction transacao = fragmentmanager.beginTransaction();


        //Fragment fragmento=null;

            switch (item.getItemId()) {

                case R.id.navigation_home:
                   transacao.replace(R.id.fragmentContainer, new ListaFrag()).commit();
                   // fragmento = new ListaFrag();
                break;

                case R.id.navigation_dashboard:
                    transacao.replace(R.id.fragmentContainer, new CadastroFrag()).commit();
                    //fragmento = new CadastroFrag();
                break;

                case R.id.navigation_notifications:
                    transacao.replace(R.id.fragmentContainer, new SobreFrag()).commit();
                   // fragmento = new SobreFrag();
                break;
            }
           // return setFragment(fragmento);
            return true;
        }




    private boolean setFragment (Fragment fragmento){

        if(fragmento!=null){
           getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, new ListaFrag())
                   // .replace(R.id.fragmentContainer, fragmento)
                    .commit();

            return true;

        }

        return false;
    }

    @Override
    public void onBackPressed() {


            // BOTAO VOLTAR DO APARELHO ANDROID - FECHAR PROGRAMA
                System.exit(0); //fecha aplicativo
                return;



    }
}
