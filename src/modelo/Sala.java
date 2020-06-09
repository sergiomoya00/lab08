/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jabre
 */
public class Sala {

    String identificador;
    String ubicacion;
    int capacidad;
    String anfitrion;
    int duracion;
    String nombreDeSala;

    public Sala(String identificador, String ubicacion, int capacidad, String anfitrion, int duracion, String nombreDeSala) {
        this.identificador = identificador;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.anfitrion = anfitrion;
        this.duracion = duracion;
        this.nombreDeSala = nombreDeSala;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getNombreDeSala() {
        return nombreDeSala;
    }

    public void setNombreDeSala(String nombreDeSala) {
        this.nombreDeSala = nombreDeSala;
    }

    public String getAnfitrion() {
        return anfitrion;
    }

    public void setAnfitrion(String anfitrion) {
        this.anfitrion = anfitrion;
    }

    public Sala() {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}
