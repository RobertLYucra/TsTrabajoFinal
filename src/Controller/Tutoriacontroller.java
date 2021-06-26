/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TutoriaModel;
import java.util.List;

/**
 *
 * @author RobertLY
 */
public class Tutoriacontroller {
    public List<Object[]> ListarTutorias(int a){
        return new TutoriaModel().ListarTutoriasPorEst(a);
    }
}
