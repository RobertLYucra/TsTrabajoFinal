/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Beans.Estudiante;
import Conexion.Conexion;
import static Conexion.Conexion.ObtenerConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author RobertLY
 */
public class EstudianteModel {
    
    public int ValidarEstudiante(String usu,String pass){
    int dato=10;        
    try{ 
        ResultSet resultSet; 

        CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call stp_validar(?,?)}");
        s.setString(1,usu);
        s.setString(2,pass);
      
        resultSet = s.executeQuery();
        
        while(resultSet.next()){
            dato = resultSet.getInt(1);
        }
      
        Conexion.ObtenerConexion().close();
        s.close();
        resultSet.close();
        return dato;
    }catch(SQLException e){
        Logger.getLogger(EstudianteModel.class.getName()).log(Level.SEVERE, null, e);
    }
    return dato;     
    }
    
    //Registrar Estudiante
    
    public boolean registrar(Estudiante est)
    {
        PreparedStatement ps = null;
        Connection con = ObtenerConexion();
        
        String sql = "INSERT INTO Estudiante (nombre, apellidos, correo, usuario, contrasena) VALUES (?, ?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, est.getNombre());
            ps.setString(2, est.getApellidos());
            ps.setString(3, est.getCorreo());
            ps.setString(4, est.getUsuario());
            ps.setString(5, est.getContrasena());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public int existeUsuario(String usuario)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ObtenerConexion();
        
        String sql = "SELECT count(idEst) FROM Estudiante WHERE usuario = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                return rs.getInt(1);
            }
            
            return 1;
          
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteModel.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }   
    
    public boolean esEmail(String correo) {

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+´)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);
        return mather.find();

    }
    
    public int CapturarID(String usu,String pass){
    int id=0;        
    try{ 
        ResultSet resultSet; 

        CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call stp_capturarid(?,?)}");
        s.setString(1,usu);
        s.setString(2,pass);
      
        //resultSet = s.executeQuery(sql); EL ERROR QUITA EL SQL :) AL COPIAR Y PEGAR SE FILTRO
        resultSet = s.executeQuery();
        
        while(resultSet.next()){
            
            id = resultSet.getInt("idEstudiante");
        }
      
        Conexion.ObtenerConexion().close();
        s.close();
        resultSet.close();
        return id;
    }catch(SQLException e){
        Logger.getLogger(EstudianteModel.class.getName()).log(Level.SEVERE, null, e);
    }
    return id;     
    }
    
    public List<Estudiante> VistaEst(Estudiante es){
    try{ 
        List<Estudiante> lst = new ArrayList<Estudiante>();
        ResultSet resultSet; 
        CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call stp_vistaest(?)}");
        s.setInt(1,es.getIdEst());
        //resultSet = s.executeQuery(sql); EL ERROR QUITA EL SQL :) AL COPIAR Y PEGAR SE FILTRO
        resultSet = s.executeQuery();
        while(resultSet.next()){
            Estudiante est = new Estudiante();
            est.setNombre(resultSet.getString("nombre"));
            est.setApellidos(resultSet.getString("apellido"));
            est.setCorreo(resultSet.getString("correo"));
            lst.add(est);
        }
      
        Conexion.ObtenerConexion().close();
        s.close();
        resultSet.close();
        return lst;
    }catch(SQLException e){
        Logger.getLogger(EstudianteModel.class.getName()).log(Level.SEVERE, null, e);
    }
    return null;     
    }
   
    
    
    
}
