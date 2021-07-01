/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Beans.Estudiante;
import Beans.Profesor;
import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RobertLY
 */
public class ProfesorModel {
    public int ValidarTutor(String usu,String pass){
    int dato=10;        
    try{ 
        ResultSet resultSet; 
        
        PreparedStatement s = Conexion.ObtenerConexion().prepareStatement("{call stp_validarpro(?,?)}");//AQUI SE AGREGA EL SQL 
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
    public int CapturarID(String usu,String pass){
    int id=0;        
    try{ 
        ResultSet resultSet; 

        CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call stp_capturaridProfesor(?,?)}");
        s.setString(1,usu);
        s.setString(2,pass);
      
        //resultSet = s.executeQuery(sql); EL ERROR QUITA EL SQL :) AL COPIAR Y PEGAR SE FILTRO
        resultSet = s.executeQuery();
        
        while(resultSet.next()){
            
            id = resultSet.getInt("idProfesor");
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
    
    public List<Profesor> VistaEst(Profesor pr){
    try{ 
        List<Profesor> lst = new ArrayList<Profesor>();
        ResultSet resultSet; 
        CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call stp_vistapro(?)}");
        s.setInt(1,pr.getIdTut());
        //resultSet = s.executeQuery(sql); EL ERROR QUITA EL SQL :) AL COPIAR Y PEGAR SE FILTRO
        resultSet = s.executeQuery();
        while(resultSet.next()){
            Profesor pro = new Profesor();
            pro.setNombre(resultSet.getString("nombre"));
            pro.setApellidos(resultSet.getString("apellido"));  
            pro.setCorreo(resultSet.getString("correo"));
            lst.add(pro);
        }
      
        Conexion.ObtenerConexion().close();
        s.close();
        resultSet.close();
        return lst;
    }catch(SQLException e){
        Logger.getLogger(ProfesorModel.class.getName()).log(Level.SEVERE, null, e);
    }
    return null;     
    }
}
