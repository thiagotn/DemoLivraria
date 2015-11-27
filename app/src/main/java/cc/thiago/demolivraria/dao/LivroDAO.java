package cc.thiago.demolivraria.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cc.thiago.demolivraria.model.Livro;

/**
 * Created by rm49824 on 26/11/2015.
 */
public class LivroDAO {

    public static final String ID           = "_id";
    public static final String TITULO       = "titulo";
    public static final String AUTOR        = "autor";
    public static final String ISBN         = "isbn";
    public static final String EDITORA      = "editora";
    public static final String DESCRICAO    = "descricao";

    private MeuBD meuBD;
    private SQLiteDatabase db;

    public LivroDAO(Context context) {
        meuBD = new MeuBD(context);
    }

    public String inserir(Livro livro) {
        ContentValues valores = new ContentValues();
        valores.put(TITULO, livro.getTitulo());
        valores.put(AUTOR, livro.getAutor());
        valores.put(ISBN, livro.getIsbn());
        valores.put(EDITORA, livro.getEditora());
        valores.put(DESCRICAO, livro.getDescricao());

        db = meuBD.getWritableDatabase();

        long resultado = db.insert(MeuBD.TABELA_LIVRO, null, valores);
        db.close();
        if (resultado == -1) {
            return "Erro ao cadastrar o livro";
        }
        return "Livro cadastrado com sucesso";
    }

    public List<Livro> getLivros() {
        List<Livro> livros = new ArrayList<Livro>();

        Cursor cursor;
        db = meuBD.getReadableDatabase();

        cursor = db.query(MeuBD.TABELA_LIVRO, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                Livro livro = new Livro();
                livro.setId(cursor.getColumnIndex(ID));
                livro.setTitulo(cursor.getString(cursor.getColumnIndex(TITULO)));
                livro.setAutor(cursor.getString(cursor.getColumnIndex(AUTOR)));
                livro.setIsbn(cursor.getString(cursor.getColumnIndex(ISBN)));
                livro.setEditora(cursor.getString(cursor.getColumnIndex(EDITORA)));
                livro.setDescricao(cursor.getString(cursor.getColumnIndex(DESCRICAO)));
                livros.add(livro);
            }
        }
        db.close();
        return livros;
    }
}
