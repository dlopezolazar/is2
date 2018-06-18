/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.model;

/**
 *
 * @author Diego
 */
public class UserModel {
    
    private Integer idUsuario;
    private String correo;
    private String nombreCompleto;
    private String uid;

    public UserModel() {
    }

    public UserModel(Integer idUsuario, String correo, String nombreCompleto, String uid) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.nombreCompleto = nombreCompleto;
        this.uid = uid;
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

    @Override
    public String toString() {
        return "UserModel{" + "idUsuario=" + idUsuario + ", correo=" + correo + ", nombreCompleto=" + nombreCompleto + ", uid=" + uid + '}';
    }
    
}
