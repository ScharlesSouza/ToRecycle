package com.example.scharles.torecycle;



import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;


public class ActivityDetails extends AppCompatActivity {

    public TextView campoTexto ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        campoTexto = (TextView)findViewById(R.id.textTitulo);

        String Nome = this.getIntent().getStringExtra("Nome");
        String Detalhes = this.getIntent().getStringExtra("Nome");
        String Data = this.getIntent().getStringExtra("Nome");
        campoTexto.setText(Nome);
    }
}
