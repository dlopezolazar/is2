/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.entities;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "usuario")
@Cacheable(false)
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="UsuSeq", sequenceName = "usuario_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "UsuSeq")
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Column(name = "uid")
    private String uid;
    @Column(name = "password")
    private String password; 
    @OneToMany(mappedBy = "usuario")
    private List<Sesion> sesionList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
//    @JsonIgnore
//    private List<Story> storyList;
    
    
    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String correo, String nombreCompleto, String uid, String password) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.nombreCompleto = nombreCompleto;
        this.uid = uid;
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.una.pol.gestprois2.entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Sesion> getSesionList() {
        return sesionList;
    }

    public void setSesionList(List<Sesion> sesionList) {
        this.sesionList = sesionList;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<Story> getStoryList() {
//        return storyList;
//    }
//
//    public void setStoryList(List<Story> storyList) {
//        this.storyList = storyList;
//    }
    
}
