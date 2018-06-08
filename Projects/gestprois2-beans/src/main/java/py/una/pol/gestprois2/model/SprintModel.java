/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.model;

import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnore;
import py.una.pol.gestprois2.entities.Proyecto;

/**
 *
 * @author Diego
 */
public class SprintModel {
    
    private Integer sprintId;
    private Date fechaInicio;
    private Date fechaFin;
    private String description;
    @JsonIgnore
    private Proyecto proyecto;

    public SprintModel() {
    }

    public SprintModel(Integer sprintId, Date fechaInicio, Date fechaFin, String description, Proyecto proyecto) {
        this.sprintId = sprintId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.description = description;
        this.proyecto = proyecto;
    }

    public Integer getSprintId() {
        return sprintId;
    }

    public void setSprintId(Integer sprintId) {
        this.sprintId = sprintId;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "SprintModel{" + "sprintId=" + sprintId + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", description=" + description + ", proyecto=" + proyecto + '}';
    }

    
    
}
