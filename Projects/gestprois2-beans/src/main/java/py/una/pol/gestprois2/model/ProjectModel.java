/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.model;

/**
 *
 * @author Diego
 */
public class ProjectModel {
    
    private Integer idProyecto;
    private String nombre;
    private String fechaInicio;
    private String fechaFin;

    public ProjectModel() {
    }

    public ProjectModel(Integer idProyecto, String nombre, String fechaInicio, String fechaFin) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "ProjectModel{" + "idProyecto=" + idProyecto + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }
    
}
