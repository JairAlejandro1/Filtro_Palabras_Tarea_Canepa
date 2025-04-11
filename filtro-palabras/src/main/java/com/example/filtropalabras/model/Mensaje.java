package com.example.filtropalabras.model;

public class Mensaje {
    private String contenido;
    private boolean filtrado;
    private int palabrasProhibidasEncontradas;

    public Mensaje(String contenido) {
        this.contenido = contenido;
        this.filtrado = false;
        this.palabrasProhibidasEncontradas = 0;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean isFiltrado() {
        return filtrado;
    }

    public void setFiltrado(boolean filtrado) {
        this.filtrado = filtrado;
    }

    public int getPalabrasProhibidasEncontradas() {
        return palabrasProhibidasEncontradas;
    }

    public void setPalabrasProhibidasEncontradas(int palabrasProhibidasEncontradas) {
        this.palabrasProhibidasEncontradas = palabrasProhibidasEncontradas;
    }

    @Override
    public String toString() {
        return contenido;
    }
}