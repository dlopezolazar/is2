/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "proyecto")
public class Proyecto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="ProySeq", sequenceName = "proyecto_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "ProySeq")
    @Column(name = "id_proyecto")
    private Integer idProyecto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
//    @JsonIgnore
//    private List<Backlog> backlogList;
//    @OneToMany(mappedBy = "proyecto")
//    @JsonIgnore
//    private List<UsuarioRol> usuarioRolList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
//    @JsonIgnore
//    private List<Sprint> sprintList;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyecto(Integer idProyecto, String nombre, Date fechaInicio, Date fechaFin) {
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }
    

//    public List<Backlog> getBacklogList() {
//        return backlogList;
//    }
//
//    public void setBacklogList(List<Backlog> backlogList) {
//        this.backlogList = backlogList;
//    }
//
//    public List<UsuarioRol> getUsuarioRolList() {
//        return usuarioRolList;
//    }
//
//    public void setUsuarioRolList(List<UsuarioRol> usuarioRolList) {
//        this.usuarioRolList = usuarioRolList;
//    }
//
//    public List<Sprint> getSprintList() {
//        return sprintList;
//    }
//
//    public void setSprintList(List<Sprint> sprintList) {
//        this.sprintList = sprintList;
//    }
    

    @Override
    public String toString() {
        return "py.una.pol.gestprois2.entities.Proyecto[ idProyecto=" + idProyecto + " ]";
    }

}
