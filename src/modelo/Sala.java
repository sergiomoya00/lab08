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

    public Sala(String identificador, String ubicacion, int capacidad) {
        this.identificador = identificador;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
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
