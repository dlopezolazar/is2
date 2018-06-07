/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "story")
public class Story implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="StorySeq", sequenceName = "story_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "StorySeq")
    @Column(name = "id_tarea")
    private Integer idTarea;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "sprint_id", referencedColumnName = "sprint_id")
    @ManyToOne(optional = false)
    private Sprint sprintId;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Story() {
    }

    public Story(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Story(Integer idTarea, String estado) {
        this.idTarea = idTarea;
        this.estado = estado;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Sprint getSprintId() {
        return sprintId;
    }

    public void setSprintId(Sprint sprintId) {
        this.sprintId = sprintId;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarea != null ? idTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Story)) {
            return false;
        }
        Story other = (Story) object;
        if ((this.idTarea == null && other.idTarea != null) || (this.idTarea != null && !this.idTarea.equals(other.idTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.una.pol.gestprois2.entities.Story[ idTarea=" + idTarea + " ]";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
