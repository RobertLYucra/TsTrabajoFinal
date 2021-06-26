/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Beans.Curso;
import Beans.Tutor;
import Beans.Tutoria;
import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RobertLY
 */
public class TutoriaModel {
    
    public List<Object[]> ListarTutoriasPorEst(int a){
        //String sql="SELECT t.fecha, t.hora, e.nombre, u.nombre, c.nombre FROM Tutoria t LEFT JOIN Estudiante e ON e.idEst = t.idEst LEFT JOIN Tutor u ON u.idTut = t.idTut LEFT JOIN Curso c ON c.idCurso = t.idCurso WHERE e.idEst=? ";
        //String sql2 = "select idTutoria, fecha, hora, idTut,idCurso from tutoria where idEst=?";
        
        try{ 
            List<Object[]> lst = new ArrayList<Object[]>();
            ResultSet resultSet; 

            CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call st_listar(?)}");
            s.setInt(1,a);
           //resultSet = (ResultSet) s.getObject(1);

            resultSet = s.executeQuery();
            while(resultSet.next()){
                String p = resultSet.getString("t.fecha");
                String q = resultSet.getString("t.hora");
                String r = resultSet.getString("u.nombre");
                String t = resultSet.getString("u.apellidos");
                String v = resultSet.getString("c.nombre");

                Object[] dato = new Object[]{p,q,r+" "+t,v};
                lst.add(dato);
            }

            Conexion.ObtenerConexion().close();
            s.close();
            resultSet.close();

            return lst;
        }catch(SQLException e){
            
            System.out.println("Algo salió mal :(" + e.getMessage());
        }
        return null;     
     }
    }

