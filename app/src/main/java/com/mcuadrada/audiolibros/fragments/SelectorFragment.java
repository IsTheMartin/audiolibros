package com.mcuadrada.audiolibros.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mcuadrada.audiolibros.AdaptadorLibros;
import com.mcuadrada.audiolibros.Aplicacion;
import com.mcuadrada.audiolibros.Libro;
import com.mcuadrada.audiolibros.MainActivity;
import com.mcuadrada.audiolibros.R;

import java.util.Vector;

public class SelectorFragment extends Fragment {
    private Activity activity;
    private RecyclerView rcvMain;
    private AdaptadorLibros adaptadorLibros;
    private Vector<Libro> vectorLibros;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        this.activity = activity;
        Aplicacion app = (Aplicacion) activity.getApplication();
        adaptadorLibros = app.getAdaptadorLibro();
        vectorLibros = app.getVectorLibros();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selector, container, false);
        rcvMain = (RecyclerView) view.findViewById(R.id.rcvMain);
        rcvMain.setLayoutManager(new GridLayoutManager(activity, 2));
        rcvMain.setAdapter(adaptadorLibros);
        adaptadorLibros.setOnItemClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Seleccionado el elemento: " +
                        rcvMain.getChildAdapterPosition(v), Toast.LENGTH_SHORT).show();
                ((MainActivity) activity).mostrarDetalle(rcvMain.getChildAdapterPosition(v));
            }
        });
        return view;
    }
}
