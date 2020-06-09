/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

/**
 *
 * @author jabre
 */
public class UsuarioDAO implements UsuarioDA {
    
    
    ArrayList<Usuario> array=new  ArrayList<>();
    Conexion conexion = new Conexion();
    Connection cin = conexion.getConnection();
    PreparedStatement ps;

    public UsuarioDAO() {
    }

    private static final UsuarioDAO instance = new UsuarioDAO();

    public static UsuarioDAO getInstance() {
        return instance;
    }

    public Usuario iniciarSesion(Usuario usuario) {
        try{
        ResultSet rs=null;
        String login = "select * from usuario where usuario='"+usuario.getNombre()+"' AND contraseña='"+usuario.getContraseña()+"'";
        ps=cin.prepareStatement(login);
        rs=ps.executeQuery();
        
        while(rs.next()){
        return usuario;
        }
          
        }
      
        catch(SQLException ex){
        
        }
        return null;

    }

    public boolean restaurarContraseña(String nombreUsuario) {
        
        return false;
    }

    public boolean cambiarContraseña(String nombreUsuario, String contraseña, String contraseñaNueva) {
        Usuario usuario=new Usuario();
        usuario.setNombre(nombreUsuario);
        usuario.setContraseña(contraseña);
        if(iniciarSesion(usuario)!=null){
        String poi = "UPDATE usuario SET contraseña='"+contraseñaNueva+"' WHERE usuario='"+nombreUsuario+"'";
        try {

            ps = cin.prepareStatement(poi);
            ps.executeUpdate();
            return true;
           

        } catch (Exception e) {

        }
        }
        return false;
    }

    @Override
    public ArrayList<Usuario> cargarListaUsuarios() {
    Usuario usuario=new Usuario();
    try{
        ResultSet rs=null;
        String login = "select * from usuario";
        ps=cin.prepareStatement(login);
        rs=ps.executeQuery();
        
        while(rs.next()){
        usuario.setNombre(rs.getString("usuario"));
        usuario.setContraseña(rs.getString("contraseña"));
        array.add(usuario);
        }
          
        }
      
        catch(SQLException ex){
        
        }
        return array;
         //To change body of generated methods, choose Tools | Templates.
    }

}
