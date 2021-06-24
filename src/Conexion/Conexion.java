/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author RobertLY
 * @author juanp
 */
public class Conexion {
    public static Connection ObtenerConexion(){
        Connection cn=null;//No hay conexion
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tutoria","root","");//verificar la conexion
            System.out.println("Conexion exitosa!!!!");
        }
        catch(Exception ex)
        {
            System.out.println("Error al conectar a la BD:"+ex.getMessage());
        }
        return cn;//si hay una  conexion
    }    
}
