/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Tutoria;
import Model.TutoriaModel;
import java.util.List;

/**
 *
 * @author RobertLY
 */
public class TutoriaController {
     public List<Object[]> ListarEstcontroller(int id){
        return new TutoriaModel().ListarTutoriasPorEst(id);
    }
     
     public List<Object[]> ListarProcontroller(int id){
        return new TutoriaModel().ListarTutoriasPorPro(id);
    }
     
    public List<Object[]> buscarEstcontroller(int id,String curso){
        return new TutoriaModel().BuscarTut(id,curso);
    }
    public void AñadirTut(Tutoria t){
        new TutoriaModel().InsertarTutoria(t);
    }
}
