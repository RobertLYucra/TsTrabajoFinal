/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Beans.Tutoria;
import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author RobertLY
 */
public class TutoriaModel {
    public List<Object[]> ListarTutoriasPorEst(int a){
       
        try{ 
            List<Object[]> lst = new ArrayList<Object[]>();
            ResultSet resultSet; 

            CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call stp_listar(?)}");
            s.setInt(1,a);
            
            resultSet = s.executeQuery();
            while(resultSet.next()){
                String p = resultSet.getString("p.fecha");
                String q = resultSet.getString("p.hora");
                String r = resultSet.getString("t.nombre");
                String t = resultSet.getString("t.apellido");
                String v = resultSet.getString("c.nombre");

                Object[] dato = new Object[]{p,q,r+" "+t,v};
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
    
    public List<Object[]> BuscarTut(int  idest,String nombrec){
       try{
        List<Object[]> lst = new ArrayList<Object[]>();
        ResultSet resultSet; 
        CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call stp_BuscarTut(?,?)}");
        s.setInt(1, idest);
        s.setString(2, nombrec);
        resultSet = s.executeQuery();
            while(resultSet.next()){
               String p = resultSet.getString("p.fecha");
                String q = resultSet.getString("p.hora");
                String r = resultSet.getString("t.nombre");
                String t = resultSet.getString("t.apellido");
                String v = resultSet.getString("c.nombre");
                
                Object[] dato = new Object[]{p,q,r+" "+t,v};
                lst.add(dato);
           }
           Conexion.ObtenerConexion().close();
            s.close();
            resultSet.close();

            return lst;
       }catch(SQLException ex){
            Logger.getLogger(TutoriaModel.class.getName()).log(Level.SEVERE, null, ex);       
       }
       return null;
    }
    
    public void InsertarTutoria(Tutoria t){
        try {
            ResultSet resultSet; 
            CallableStatement s = Conexion.ObtenerConexion().prepareCall("{call stp_InsertTutoria(?,?)}");
            s.setInt(1, t.getIdprogramaclase());
            s.setInt(2, t.getIdestudiante());
            resultSet = s.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error!!!!"+ ex.getMessage());
        }
    }
    
}
