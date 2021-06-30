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
public class ProgramaClase {
    private int idprogramaclase ;
    private String fecha  ;
    private String hora  ;
    private String idZoom ;
    private int idTut;
    private int idCurso;

    public ProgramaClase(int idprogramaclase, String fecha, String hora, String idZoom, int idTut, int idCurso) {
        this.idprogramaclase = idprogramaclase;
        this.fecha = fecha;
        this.hora = hora;
        this.idZoom = idZoom;
        this.idTut = idTut;
        this.idCurso = idCurso;
    }
    public ProgramaClase  (){
        
    }

 

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdprogramaclase() {
        return idprogramaclase;
    }

    public void setIdprogramaclase(int idprogramaclase) {
        this.idprogramaclase = idprogramaclase;
    }

    public String getIdZoom() {
        return idZoom;
    }

    public void setIdZoom(String idZoom) {
        this.idZoom = idZoom;
    }


    public int getIdTut() {
        return idTut;
    }

    public void setIdTut(int idTut) {
        this.idTut = idTut;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    
    
    

}
