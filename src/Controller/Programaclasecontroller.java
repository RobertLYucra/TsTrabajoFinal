/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ProgramaclaseModel;
import java.util.List;

/**
 *
 * @author RobertLY
 */
public class Programaclasecontroller {
    
    public List<Object[]> ListarProcontroller(){
        return new ProgramaclaseModel().ListarTutoriasTut();
    }
    public List<Object[]> buscarProcontroller(String curso){
        return new ProgramaclaseModel().BuscarPro(curso);
    }
}
