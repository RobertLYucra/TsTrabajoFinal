/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ProfesorModel;

/**
 *
 * @author RobertLY
 */
public class TutorController {
     public int ValidarTutControlador(String usu,String pass){
        return new ProfesorModel().ValidarTutor(usu,pass);
    }
}
