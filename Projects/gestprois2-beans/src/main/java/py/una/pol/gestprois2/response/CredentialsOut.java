/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.response;

import java.util.Date;

/**
 *
 * @author Diego
 */
public class CredentialsOut {
    
    private String accesToken;
    private Date session;

    public String getAccesToken() {
        return accesToken;
    }

    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }

    public Date getSession() {
        return session;
    }

    public void setSession(Date session) {
        this.session = session;
    }
    
    
}
