/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Sala;
import modelo.Usuario;

/**
 *
 * @author samoy
 */
public class SalaDAO implements SalaDA {

    ArrayList<Sala> array = new ArrayList<>();
    Conexion conexion = new Conexion();
    Connection cin = conexion.getConnection();
    PreparedStatement ps;

    public SalaDAO() {
    }

    private static final SalaDAO instance = new SalaDAO();

    public static SalaDAO getInstance() {
        return instance;
    }

    @Override
    public void crearSala(String ubicacion, int capacidad, String anfitrion, int duracion, String nombreDeSala) {
        
        String insertar = "insert into sala(ubicacion,capacidad,anfitrion,duracion,nombreDeSala) values (?,?,?,?,?) ";

        try {
            ps = cin.prepareCall(insertar);
            ps.setString(1, ubicacion);
            ps.setInt(2, capacidad);
            ps.setString(3, anfitrion);
            ps.setInt(4, duracion);
            ps.setString(5, nombreDeSala);

            int registro = ps.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(this, " registrado con exito", "Bien", JOptionPane.QUESTION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, " no se registro con exito", "atencion", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {

        }
    }

    @Override
    public boolean modificarCantidad(String nombre, int nuevaCapacidad) {
        
        
        String poi = "UPDATE salas SET capacidad="+nuevaCapacidad+" WHERE nombre= '"+nombre+"'";
        try {

            ps = cin.prepareStatement(poi);
            ps.executeUpdate();
            return true;
           

        } catch (Exception e) {

        }
        
        return false;
    }

    @Override
    public ArrayList<Sala> cargarListaSalas() {
        Sala sala = new Sala();
        try {
            ResultSet rs = null;
            String login = "select * from sala";
            ps = cin.prepareStatement(login);
            rs = ps.executeQuery();

            while (rs.next()) {
                sala.setIdentificador(rs.getString("identificador"));
                sala.setUbicacion(rs.getString("ubicacion"));
                sala.setCapacidad(rs.getInt("capacidad"));
                sala.setAnfitrion(rs.getString("anfitrion"));
                sala.setDuracion(rs.getInt("duracion"));
                sala.setNombreDeSala(rs.getString("nombreDeSala"));
                array.add(sala);
            }

        } catch (SQLException ex) {

        }
        return array;
    }

    @Override
    public String obtenerAnfitrion(String identificador) {
        
        String usuario="";
    try{
        ResultSet rs=null;
        String login = "select anfitrion from salas where id="+Integer.parseInt(identificador);
        ps=cin.prepareStatement(login);
        rs=ps.executeQuery();
        
        while(rs.next()){
        usuario=rs.getString("anfitrion");
        }
          
        }
      
        catch(SQLException ex){
        
        }
    return usuario;
        
         //To change body of generated methods, choose Tools | Templates.
    
    }

}
