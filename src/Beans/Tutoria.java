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
    private int idTutoria ;
    private String fecha  ;
    private String hora  ;
    private String descripcion ;
    private int idEst;
    private int idTut;
    private int idCurso;

    public Tutoria(int idTutoria, String fecha, String hora, String descripcion, int idEst, int idTut, int idCurso) {
        this.idTutoria = idTutoria;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.idEst = idEst;
        this.idTut = idTut;
        this.idCurso = idCurso;
    }
    public Tutoria  (){
        
    }

    public int getIdTutoria() {
        return idTutoria;
    }

    public void setIdTutoria(int idTutoria) {
        this.idTutoria = idTutoria;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
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
