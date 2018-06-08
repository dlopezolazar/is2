/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.response;

import py.una.pol.gestprois2.model.ProjectModel;
import py.una.pol.gestprois2.model.SprintModel;
import py.una.pol.gestprois2.model.UserModel;

/**
 *
 * @author Diego
 */
public class StoryResponse {
    
    private Integer idTarea;
    private String descripcion;
    private String estado;
    private SprintModel sprint;
    private UserModel usuario;

    public StoryResponse() {
    }

    public StoryResponse(Integer idTarea, String descripcion, String estado, SprintModel sprint, UserModel usuario) {
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.estado = estado;
        this.sprint = sprint;
        this.usuario = usuario;
    }
    
    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public SprintModel getSprint() {
        return sprint;
    }

    public void setSprint(SprintModel sprint) {
        this.sprint = sprint;
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "StoryResponse{" + "idTarea=" + idTarea + ", descripcion=" + descripcion + ", estado=" + estado + ", sprint=" + sprint + ", usuario=" + usuario + '}';
    }
    
    
    
}
