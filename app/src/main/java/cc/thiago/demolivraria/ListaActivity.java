package cc.thiago.demolivraria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import cc.thiago.demolivraria.adapter.LivrosAdapter;
import cc.thiago.demolivraria.dao.LivroDAO;
import cc.thiago.demolivraria.model.Livro;

public class ListaActivity extends AppCompatActivity {

    private ListView lvLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        LivroDAO crud = new LivroDAO(this);

        Livro livro = new Livro();
        livro.setDescricao("Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis.\n");
        livro.setTitulo("Android é TOP");
        livro.setEditora("");
        livro.setIsbn("1121212");
        livro.setAutor("Google");
        crud.inserir(livro);
        lvLivros = (ListView) findViewById(R.id.lvLivros);
        lvLivros.setAdapter(new LivrosAdapter(this, crud.getLivros()));
    }
}
