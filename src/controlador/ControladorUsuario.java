/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuarioDAO;
import modelo.Usuario;
import vista.LoginForm;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author jabre
 */
public class ControladorUsuario {

    public LoginForm vista;
    public UsuarioDAO dao;
    public Usuario modelo;

    public ControladorUsuario(LoginForm pVista, Usuario pModelo) {
        vista = pVista;
        modelo = pModelo;
        UsuarioDAO dao = new UsuarioDAO();

        this.vista.btIniciarLogin.addActionListener((ActionListener) this);
        this.vista.btCancelarLogin.addActionListener((ActionListener) this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Iniciar logIn":
                logIn();
                break;
            case "Cancelar Login":
                cerrarVentanaLogin();
                break;
            default:
                break;
        }
    }

    public void logIn() {
        if (vista.logInDatosCorrectos() == true) {
            String nombreUsuario = vista.txtNombreUsuario.getText();
            String contraseña = vista.txtContraseña.getText();

            modelo = new Usuario(nombreUsuario, contraseña);
            Usuario usuarioActual = dao.iniciarSesion(modelo);

            if (usuarioActual != null) {
                vista.setVisible(false);
                JOptionPane.showMessageDialog(vista, "Bienvenido: " + modelo.getNombre());
                vista.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(vista, "El usuario indicado no existe");
            }

        } else {
            JOptionPane.showMessageDialog(vista, "Todos los datos son requeridos");
        }

    }

    public void cerrarVentanaLogin() {
        vista.cancelarInicioSesion();
    }
}
