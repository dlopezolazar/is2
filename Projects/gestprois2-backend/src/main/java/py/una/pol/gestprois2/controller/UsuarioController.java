/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.net.URI;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
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
import py.una.pol.gestprois2.entities.Usuario;
import py.una.pol.gestprois2.facade.UsuarioFacade;

/**
 *
 * @author Diego
 */
@Api
@Path("/usuario")
@Named
public class UsuarioController{
    @EJB
    private UsuarioFacade usuario;
    
    private static final Logger LOGGER = Logger.getLogger(UsuarioController.class);
    
    private static final String USUARIO     = "/{userId}";
    
    /**
     * List all Users
     * @return List<Usuario> 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){
        System.out.println("Pase por aca");
        List<Usuario> listAllUsers =  usuario.findAll();
        if(listAllUsers.isEmpty()){
            return Response.noContent().build();
        }
        return Response.ok(listAllUsers).build();
    }
    
    /**
     * Return a simple User by id
     * @param userId 
     * @return 
     */
    @GET
    @Path(USUARIO)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Returns a User")
    public Response getUser(@PathParam("userId") Integer userId){
        
        Usuario usu = usuario.find(userId);
        
        if(usu == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return Response.ok(usu).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Save a User")
    public Response saveUser(Usuario usu){
        try {
            usuario.create(usu);
            return Response.created(URI.create("")).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Update a user")
    public Response updateUser(){
        
        return null;
    }
    
    /**
     * 
     * @param userId
     * @return 
     */
    @DELETE
    @Path(USUARIO)
    @ApiOperation(value = "Delete a subresource")
    public Response deleteUser(@PathParam("userId") Integer userId){
        
        return Response.ok().build();
    }
    
}