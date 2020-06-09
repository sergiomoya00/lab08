/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.Sala;

/**
 *
 * @author samoy
 */
public interface SalaDA {

    void crearSala(String ubicacion, int capacidad, String anfitrion, int duracion, String nombreDeSala);

    boolean modificarCantidad(String identificador, int cantidad, int nuevaCantidad);

    ArrayList<Sala> cargarListaSalas();

    void obtenerAnfitrion(String identificador);
}
