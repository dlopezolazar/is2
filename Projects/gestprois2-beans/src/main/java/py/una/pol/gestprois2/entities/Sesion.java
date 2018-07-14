/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "sesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sesion.findAll", query = "SELECT s FROM Sesion s"),
    @NamedQuery(name = "Sesion.findByIdSesion", query = "SELECT s FROM Sesion s WHERE s.idSesion = :idSesion"),
    @NamedQuery(name = "Sesion.findByAccessToken", query = "SELECT s FROM Sesion s WHERE s.accessToken = :accessToken"),
    @NamedQuery(name = "Sesion.findBySesionFechaHora", query = "SELECT s FROM Sesion s WHERE s.sesionFechaHora = :sesionFechaHora"),
    @NamedQuery(name = "Sesion.findByEstadoSession", query = "SELECT s FROM Sesion s WHERE s.estadoSession = :estadoSession")})
public class Sesion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sesion")
    private Integer idSesion;
    @Size(max = 2147483647)
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "sesion_fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sesionFechaHora;
    @Column(name = "estado_session")
    private Integer estadoSession;
    @JoinColumn(name = "usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    public Sesion() {
    }

    public Sesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getSesionFechaHora() {
        return sesionFechaHora;
    }

    public void setSesionFechaHora(Date sesionFechaHora) {
        this.sesionFechaHora = sesionFechaHora;
    }

    public Integer getEstadoSession() {
        return estadoSession;
    }

    public void setEstadoSession(Integer estadoSession) {
        this.estadoSession = estadoSession;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSesion != null ? idSesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sesion)) {
            return false;
        }
        Sesion other = (Sesion) object;
        if ((this.idSesion == null && other.idSesion != null) || (this.idSesion != null && !this.idSesion.equals(other.idSesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.una.pol.gestprois2.entities.Sesion[ idSesion=" + idSesion + " ]";
    }
    
}
