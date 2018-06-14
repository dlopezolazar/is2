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

    public UserModel() {
    }

    public UserModel(Integer idUsuario, String correo, String nombreCompleto) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.nombreCompleto = nombreCompleto;
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

    @Override
    public String toString() {
        return "UserModel{" + "correo=" + correo + ", nombreCompleto=" + nombreCompleto + '}';
    }

   
    
}
