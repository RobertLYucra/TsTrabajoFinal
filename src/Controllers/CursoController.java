/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Curso;
import Model.CursoModel;
import javax.swing.JComboBox;

/**
 *
 * @author RobertLY
 */
public class CursoController {
    public void ListarCursoCOntroller(JComboBox cbo){
        new CursoModel().getListadoCursosCbo(cbo);
    }
    
    public int CapturarIdCursoController(Curso c){
        return new CursoModel().CapturarIDCurso(c);
    }
}
