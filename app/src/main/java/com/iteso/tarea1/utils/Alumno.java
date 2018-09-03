package com.iteso.tarea1.utils;

import android.widget.Button;
import android.widget.RadioGroup;

public class Alumno {

    private String nombre;
    private String telefono;
    private String escolaridad;
    private String genero;
    private String libro;
    private Boolean deporte;
    private Boolean lib;

    public Alumno(String nombrec, String telefonoc, String escolaridadc,
                  int generoc, String  libroc, Boolean deportec){
        setNombre(nombrec);
        setTelefono(telefonoc);
        setEscolaridad(escolaridadc);
        setGenero(generoc);
        setLibro(libroc);
        setDeporte(deportec);
        setLibro(libroc);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombref) {
        this.nombre = nombref;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefonof) {
        this.telefono = telefonof;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridadf) {
        this.escolaridad = escolaridadf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(int generof) {
        if(generof == 0)
            this.genero = "Femenino";
        else
            this.genero = "Masculino";
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String librof) {
        if(libro != "") {
            this.libro = librof;
            this.lib = true;
        }
        else {
            this.libro = "";
            this.lib = false;
        }
    }

    public String getDeporte() {
        if(this.deporte)
            return "Si";
        else
            return "No";
    }

    public void setDeporte(Boolean deportef) {
        this.deporte = deportef;
    }

    @Override
    public String toString() {
        if(lib)
        return "Nombre: " + getNombre()
                + "\nTelefono: " + getTelefono()
                + "\nEscolaridad: " + getEscolaridad()
                + "\nGénero: " + getGenero()
                + "\nLibro Fávorito: " + getLibro()
                + "\nPractica Deporte: " + getDeporte();
        else
            return "Nombre: " + getNombre()
                    + "\nTelefono: " + getTelefono()
                    + "\nEscolaridad: " + getEscolaridad()
                    + "\nGénero: " + getGenero()
                    + "\nPractica Deporte: " + getDeporte();
    }
}
