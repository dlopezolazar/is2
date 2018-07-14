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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "usuario_rol")
public class UsuarioRol implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_usuario_rol")
    private Integer idUsuarioRol;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne
    private Proyecto proyecto;
//    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
//    @ManyToOne(optional = false)
//    private Rol idRol;
//    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
//    @ManyToOne(optional = false)
//    private Usuario usuario;

    public UsuarioRol() {
    }

    public UsuarioRol(Integer idUsuarioRol) {
        this.idUsuarioRol = idUsuarioRol;
    }

    public Integer getIdUsuarioRol() {
        return idUsuarioRol;
    }

    public void setIdUsuarioRol(Integer idUsuarioRol) {
        this.idUsuarioRol = idUsuarioRol;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setIdProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

//    public Rol getIdRol() {
//        return idRol;
//    }
//
//    public void setIdRol(Rol idRol) {
//        this.idRol = idRol;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioRol != null ? idUsuarioRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.idUsuarioRol == null && other.idUsuarioRol != null) || (this.idUsuarioRol != null && !this.idUsuarioRol.equals(other.idUsuarioRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.una.pol.gestprois2.entities.UsuarioRol[ idUsuarioRol=" + idUsuarioRol + " ]";
    }
    
}
