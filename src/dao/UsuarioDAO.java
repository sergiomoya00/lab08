/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author jabre
 */
public class UsuarioDAO implements UsuarioDA {
    
    Conexion conexion = new Conexion();
    Connection cin = conexion.getConnection();
    PreparedStatement ps;
    
    public UsuarioDAO(){}
    
    
    public Usuario iniciarSesion(Usuario usuario){
         String insertar = "select  into equipo(idEquipo,idUsuario,presupuesto,puntos,golesFavor,golesContra,golesDiferencia,partidosJugados,partidosGanados,partidosPerdidos,emaptes,divison) values (?,?,?,?,?,?,?,?,?,?,?,?) ";
               
                try {
                    ps = cin.prepareCall(insertar);
                    ps.setString(1, txtequipo.getText());
                    ps.setString(2, txtNombre.getText());
                    ps.setInt(3, 0);
                    ps.setInt(4, 0);
                    ps.setInt(5, 0);
                    ps.setInt(6, 0);
                    ps.setInt(7, 0);
                    ps.setInt(8, 0);
                    ps.setInt(9, 0);
                    ps.setInt(10, 0);
                    ps.setInt(11, 0);
                    ps.setInt(12, Integer.parseInt(combodivision.getSelectedItem().toString()));

                    int registro = ps.executeUpdate();
                    if (registro > 0) {
                        JOptionPane.showMessageDialog(this, " registrado con exito", "Bien", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, " no se registro con exito", "atencion", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception e) {

                }
       
        return usuario;
    
    }
    public boolean restaurarContraseña(String nombreUsuario){return false;
}
   
    public boolean cambiarContraseña(String nombreUsuario,String contraseña,String contraseñaNueva){return false;
}

    @Override
    public ArrayList<Usuario> cargarListaUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
