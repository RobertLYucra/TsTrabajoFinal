/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.Estudiante;
import Model.EstudianteModel;

/**
 *
 * @author RobertLY
 */
public class EstudianteController {
    public int ValidarEstControlador(String usu,String pass){
        return new EstudianteModel().ValidarEstudiante(usu,pass);
    }
    public int CapturarIDcontrollwe(String usu,String pass){
        return new EstudianteModel().CapturarID(usu,pass);
    }
            
}
