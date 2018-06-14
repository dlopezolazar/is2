/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.controller;

import java.net.URI;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import py.una.pol.gestprois2.entities.UsuarioRol;
import py.una.pol.gestprois2.facade.UsuarioRolFacade;

/**
 *
 * @author Diego
 */
@Path("/user-rol")
@Stateless
public class UserRolController {
    
    @EJB
    private UsuarioRolFacade userRol;
    
    private static final Logger LOGGER       = Logger.getLogger(UsuarioController.class);
    
    private static final String USUARIO_ROL  = "/{userRolId}";
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){
        
        List<UsuarioRol> listAllUsers =  userRol.findAll();
        if(listAllUsers.isEmpty()){
            return Response.noContent().build();
        }
        return Response.ok(listAllUsers).build();
    }
    
    /**
     * Return a simple UserRol by id 
     * @param userRolId
     * @return 
     */
    @GET
    @Path(USUARIO_ROL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userRolId") Integer userRolId){
        
        UsuarioRol usu = userRol.find(userRolId);
        
        if(usu == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return Response.ok(usu).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveUser(UsuarioRol usu){
        try {
            userRol.create(usu);
            return Response.created(URI.create("")).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(UsuarioRol usu){
        try {
            userRol.edit(usu);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
    }
    
    /**
     * 
     * @param userRolId
     * @return 
     */
    @DELETE
    @Path(USUARIO_ROL)
    public Response deleteUser(@PathParam("userRolId") Integer userRolId){
        UsuarioRol u = userRol.find(userRolId);
        userRol.remove(u);
        return Response.ok().build();
    }
}
