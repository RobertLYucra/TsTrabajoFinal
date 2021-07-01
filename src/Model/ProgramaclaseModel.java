/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Beans.Curso;
import Beans.Profesor;
import Beans.ProgramaClase;
import Conexion.Conexion;
import java.sql.CallableStatement;
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
public class ProgramaclaseModel {
      
    public List<Object[]> ListarTutoriasTut(){
        //String sql="SELECT t.fecha, t.hora, e.nombre, u.nombre, c.nombre FROM Tutoria t LEFT JOIN Estudiante e ON e.idEst = t.idEst LEFT JOIN Tutor u ON u.idTut = t.idTut LEFT JOIN Curso c ON c.idCurso = t.idCurso WHERE e.idEst=? ";
        //String sql2 = "select idTutoria, fecha, hora, idTut,idCurso from tutoria where idEst=?";
        
        try{ 
            List<Object[]> lst = new ArrayList<Object[]>();
            ResultSet resultSet; 

            CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call stp_listarPro()}");
           //resultSet = (ResultSet) s.getObject(1);
            resultSet = s.executeQuery();
            while(resultSet.next()){
                
                String p = resultSet.getString("t.fecha");
                String q = resultSet.getString("t.hora");
                String r = resultSet.getString("p.nombre");
                String t = resultSet.getString("p.apellido");
                String v = resultSet.getString("c.nombre");

                Object[] dato = new Object[]{p,q,r,t,v};
                lst.add(dato);
            }

            Conexion.ObtenerConexion().close();
            s.close();
            resultSet.close();

            return lst;
        }catch(SQLException e){
            
            System.out.println("Algo salió mal -.- :(" + e.getMessage());
        }
        return null;     
     }
    
     public List<Object[]> BuscarPro(String  curso){
       try{
        List<Object[]> lst = new ArrayList<Object[]>();
        ResultSet resultSet; 
        CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call stp_buscarPro(?)}");
        s.setString(1, curso);
        resultSet = s.executeQuery();
            while(resultSet.next()){
               String p = resultSet.getString("t.fecha");
                String q = resultSet.getString("t.hora");
                String r = resultSet.getString("p.nombre");
                String t = resultSet.getString("p.apellido");
                String v = resultSet.getString("c.nombre");
                
                Object[] dato = new Object[]{p,q,r,t,v};
                lst.add(dato);
           }
           Conexion.ObtenerConexion().close();
            s.close();
            resultSet.close();

            return lst;
       }catch(SQLException ex){
            Logger.getLogger(ProgramaclaseModel.class.getName()).log(Level.SEVERE, null, ex);       
       }
       return null;
    }
     
     
    public int CapturarID(String fech,String hor, String nombrep,String apellidosp,String curso){
        int id=1;        
        try{ 
            ResultSet resultSet; 

            CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call stp_buscaridPro(?,?,?,?,?)}");
            s.setString(1,fech);
            s.setString(2,hor);
            s.setString(3,nombrep);
            s.setString(4,apellidosp);
            s.setString(5,curso);
            
            

            //resultSet = s.executeQuery(sql); EL ERROR QUITA EL SQL :) AL COPIAR Y PEGAR SE FILTRO
            resultSet = s.executeQuery();

            while(resultSet.next()){

                id = resultSet.getInt("idProgramacion");
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
     
    

