/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author RobertLY
 */
public class Tutoria {
    private int idestudiante;
    private int idprogramaclase;

    public Tutoria(int idestudiante, int idprogramaclase) {
        this.idestudiante = idestudiante;
        this.idprogramaclase = idprogramaclase;
    }

    public Tutoria(){
        
    }
    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

    public int getIdprogramaclase() {
        return idprogramaclase;
    }

    public void setIdprogramaclase(int idprogramaclase) {
        this.idprogramaclase = idprogramaclase;
    }
    
    
    
}
