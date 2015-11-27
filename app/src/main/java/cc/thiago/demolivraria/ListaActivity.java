package cc.thiago.demolivraria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListaActivity extends AppCompatActivity {

    private ListView lvLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvLivros = (ListView) findViewById(R.id.lvLivros);
    }
}
