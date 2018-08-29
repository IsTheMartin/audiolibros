package com.mcuadrada.audiolibros;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

public class AdaptadorLibros extends RecyclerView.Adapter<AdaptadorLibros.ViewHolder> {

    private LayoutInflater inflador;
    protected Vector<Libro> vectorLibro;
    private Context context;
    private View.OnClickListener onClickListener;

    public AdaptadorLibros(Vector<Libro> vectorLibro, Context context) {
        inflador = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.vectorLibro = vectorLibro;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflador.inflate(R.layout.elemento_selector, null);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Libro libro = vectorLibro.elementAt(position);
        holder.imgPortada.setImageResource(libro.recursoImagen);
        holder.tvTitulo.setText(libro.titulo);
    }

    @Override
    public int getItemCount() {
        return vectorLibro.size();
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPortada;
        public TextView tvTitulo;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imgPortada = (ImageView) itemView.findViewById(R.id.imgPortada);
            this.tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
        }
    }
}
