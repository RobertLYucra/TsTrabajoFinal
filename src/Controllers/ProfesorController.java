/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Profesor;
import Model.ProfesorModel;
import java.util.List;

/**
 *
 * @author RobertLY
 */
public class ProfesorController {
     public int ValidarTutControlador(String usu,String pass){
        return new ProfesorModel().ValidarTutor(usu,pass);
    }
     public int CapturarIDcontrollwe(String usu,String pass){
        return new ProfesorModel().CapturarID(usu,pass);
    }
    
   public List<Profesor> VistaProcontroller(Profesor es){
       return new  ProfesorModel().VistaEst(es);
   }
}
