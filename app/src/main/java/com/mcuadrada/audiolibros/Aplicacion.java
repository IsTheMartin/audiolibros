package com.mcuadrada.audiolibros;

import android.app.Application;

import java.util.Vector;

public class Aplicacion extends Application {
    private Vector<Libro> vectorLibros;
    private AdaptadorLibros adaptadorLibros;

    @Override
    public void onCreate() {
        super.onCreate();
        vectorLibros = Libro.ejemploLibros();
        adaptadorLibros = new AdaptadorLibros(vectorLibros, this);
    }

    public AdaptadorLibros getAdaptadorLibro() {
        return adaptadorLibros;
    }

    public Vector<Libro> getVectorLibros() {
        return vectorLibros;
    }
}
