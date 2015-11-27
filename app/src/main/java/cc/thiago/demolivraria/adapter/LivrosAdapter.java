package cc.thiago.demolivraria.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import cc.thiago.demolivraria.R;
import cc.thiago.demolivraria.model.Livro;

/**
 * Created by rm49824 on 26/11/2015.
 */
public class LivrosAdapter extends BaseAdapter {

    private Context context;
    private List<Livro> livros;

    public LivrosAdapter(Context context, List<Livro> livros) {
        this.context = context;
        this.livros = livros;
    }

    @Override
    public int getCount() {
        return livros.size();
    }

    @Override
    public Object getItem(int position) {
        return livros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return livros.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.item_livro, parent, false);
        
        return null;
    }
}
