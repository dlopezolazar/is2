/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "backlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Backlog.findAll", query = "SELECT b FROM Backlog b"),
    @NamedQuery(name = "Backlog.findByIdBacklog", query = "SELECT b FROM Backlog b WHERE b.idBacklog = :idBacklog"),
    @NamedQuery(name = "Backlog.findByDescripcion", query = "SELECT b FROM Backlog b WHERE b.descripcion = :descripcion")})
public class Backlog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @javax.validation.constraints.NotNull
    @javax.validation.constraints.Size(min = 1, max = 2147483647)
    @Column(name = "id_backlog")
    private String idBacklog;
    @Basic(optional = false)
    @javax.validation.constraints.NotNull
    @javax.validation.constraints.Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBacklog")
    private List<Requerimiento> requerimientoList;

    public Backlog() {
    }

    public Backlog(String idBacklog) {
        this.idBacklog = idBacklog;
    }

    public Backlog(String idBacklog, String descripcion) {
        this.idBacklog = idBacklog;
        this.descripcion = descripcion;
    }

    public String getIdBacklog() {
        return idBacklog;
    }

    public void setIdBacklog(String idBacklog) {
        this.idBacklog = idBacklog;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    @XmlTransient
    public List<Requerimiento> getRequerimientoList() {
        return requerimientoList;
    }

    public void setRequerimientoList(List<Requerimiento> requerimientoList) {
        this.requerimientoList = requerimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBacklog != null ? idBacklog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Backlog)) {
            return false;
        }
        Backlog other = (Backlog) object;
        if ((this.idBacklog == null && other.idBacklog != null) || (this.idBacklog != null && !this.idBacklog.equals(other.idBacklog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.una.pol.gestprois2.entities.Backlog[ idBacklog=" + idBacklog + " ]";
    }
    
}
