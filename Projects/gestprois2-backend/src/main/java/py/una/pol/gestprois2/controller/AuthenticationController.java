/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.controller;

import java.util.Base64;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import py.una.pol.gestprois2.entities.Usuario;
import py.una.pol.gestprois2.facade.UsuarioFacade;
import py.una.pol.gestprois2.request.Credentials;
import py.una.pol.gestprois2.response.CredentialsOut;

/**
 *
 * @author Diego
 */
@Path("/authentication")
@Stateless
public class AuthenticationController {
    
    @EJB
    private UsuarioFacade facadeUsu;
    
    private static final Logger LOGGER = Logger.getLogger(AuthenticationController.class);
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(Credentials credentials) {
        try {

            // Authenticate the user using the credentials provided
            Usuario u = facadeUsu.validateUser(credentials.getUsername(), credentials.getPassword());
//          // Issue a token for the user
            String token = issueToken(u.getNombreCompleto()+credentials.getPassword());
//
//          // Return the token on the response
            CredentialsOut out = new CredentialsOut();
            out.setAccesToken(token);
            out.setSession(new Date());
            
            return Response.ok(out).build();
            
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(Response.Status.FORBIDDEN).build();
        }      
    }

    private String issueToken(String param) {
        
        return Base64.getEncoder().encodeToString((param).getBytes());
    }
}
