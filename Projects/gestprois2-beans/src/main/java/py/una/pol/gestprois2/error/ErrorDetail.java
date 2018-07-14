/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.error;

/**
 *
 * @author Diego
 */
public class ErrorDetail {
    
    private String descripcion;

    public ErrorDetail(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ErrorDetail{" + "descripcion=" + descripcion + '}';
    }
    
    
}
