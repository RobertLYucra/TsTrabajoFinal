/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Beans.Estudiante;
import Conexion.Conexion;
import static Conexion.Conexion.ObtenerConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author RobertLY
 */
public class EstudianteModel {
    
    public int ValidarEstudiante(String usu,String pass){
    int dato=10;        
    String sql="SELECT 	COUNT(*) FROM Estudiante WHERE usuario=? and contrasena=?";
    try{ 
        ResultSet resultSet; 
        
        PreparedStatement s = Conexion.ObtenerConexion().prepareStatement(sql);//AQUI SE AGREGA EL SQL 
        s.setString(1,usu);
        s.setString(2,pass);
      
        //resultSet = s.executeQuery(sql); EL ERROR QUITA EL SQL :) AL COPIAR Y PEGAR SE FILTRO
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
    
    public int CapturarID(String usu,String pass){
    int dato=10;        
    String sql="SELECT 	idEst FROM Estudiante WHERE usuario=? and contrasena=?";
    try{ 
        ResultSet resultSet; 
        
        PreparedStatement s = Conexion.ObtenerConexion().prepareStatement(sql);//AQUI SE AGREGA EL SQL 
        s.setString(1,usu);
        s.setString(2,pass);
      
        //resultSet = s.executeQuery(sql); EL ERROR QUITA EL SQL :) AL COPIAR Y PEGAR SE FILTRO
        resultSet = s.executeQuery();
        
        while(resultSet.next()){
            
            dato = resultSet.getInt("idEst");
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
    
    
    
}
