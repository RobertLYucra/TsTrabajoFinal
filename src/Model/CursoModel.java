/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Beans.Curso;
import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author RobertLY
 */
public class CursoModel {
    public void getListadoCursosCbo(JComboBox cbo){
        try{
            ResultSet resultSet; 

            CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call stp_listarcurso()}");    
        //resultSet = s.executeQuery(sql); EL ERROR QUITA EL SQL :) AL COPIAR Y PEGAR SE FILTRO
        resultSet = s.executeQuery();
            while(resultSet.next()){
                cbo.addItem(resultSet.getString("Nombre"));
            }
        }catch(Exception ex){
            System.out.print(ex.getMessage());
        }
    }
    public int CapturarIDCurso(Curso c){
    int id=0;        
    try{ 
        ResultSet resultSet; 

        CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call capturarIDcurso(?)}");
        s.setString(1,c.getNombre());
      
        //resultSet = s.executeQuery(sql); EL ERROR QUITA EL SQL :) AL COPIAR Y PEGAR SE FILTRO
        resultSet = s.executeQuery();
        
        while(resultSet.next()){
            
            id = resultSet.getInt("idCurso");
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
}
