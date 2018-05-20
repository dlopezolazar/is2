/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnore;
import py.una.pol.gestprois2.entities.Proyecto;

/**
 *
 * @author Diego
 */
public class SprintModel {
    
    private Integer sprintId;
    private Date initDate;
    private Date endDate;
    private String sprintDescription;
    @JsonIgnore
    private Proyecto project;

    public SprintModel() {
    }

    public SprintModel(Integer sprintId, Date initDate, Date endDate, String sprintDescription, Proyecto project) {
        this.sprintId = sprintId;
        this.initDate = initDate;
        this.endDate = endDate;
        this.sprintDescription = sprintDescription;
        this.project = project;
    }

    public Integer getSprintId() {
        return sprintId;
    }

    public void setSprintId(Integer sprintId) {
        this.sprintId = sprintId;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSprintDescription() {
        return sprintDescription;
    }

    public void setSprintDescription(String sprintDescription) {
        this.sprintDescription = sprintDescription;
    }

    public Proyecto getProject() {
        return project;
    }

    public void setProject(Proyecto project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "SprintModel{" + "sprintId=" + sprintId + ", initDate=" + initDate + ", endDate=" + endDate + ", sprintDescription=" + sprintDescription + ", project=" + project + '}';
    }
    
    
    
}
