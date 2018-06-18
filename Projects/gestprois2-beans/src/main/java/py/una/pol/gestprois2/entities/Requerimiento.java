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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "requerimiento")
public class Requerimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_requerimiento")
    private Integer idRequerimiento;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
//    @JoinColumn(name = "id_backlog", referencedColumnName = "id_backlog")
//    @ManyToOne(optional = false)
//    private Backlog idBacklog;

    public Requerimiento() {
    }

    public Requerimiento(Integer idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public Requerimiento(Integer idRequerimiento, String descripcion) {
        this.idRequerimiento = idRequerimiento;
        this.descripcion = descripcion;
    }

    public Integer getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(Integer idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

//    public Backlog getIdBacklog() {
//        return idBacklog;
//    }
//
//    public void setIdBacklog(Backlog idBacklog) {
//        this.idBacklog = idBacklog;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequerimiento != null ? idRequerimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requerimiento)) {
            return false;
        }
        Requerimiento other = (Requerimiento) object;
        if ((this.idRequerimiento == null && other.idRequerimiento != null) || (this.idRequerimiento != null && !this.idRequerimiento.equals(other.idRequerimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.una.pol.gestprois2.entities.Requerimiento[ idRequerimiento=" + idRequerimiento + " ]";
    }
    
}
