/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author jabre
 */
public interface UsuarioDA {

    Usuario iniciarSesion(Usuario usuario);

    boolean restaurarContraseña(String nombreUsuario);

    ArrayList<Usuario> cargarListaUsuarios();

    boolean cambiarContraseña(String nombreUsuario, String contraseña, String contraseñaNueva);

}
