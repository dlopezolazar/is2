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
import py.una.pol.gestprois2.entities.Rol;
import py.una.pol.gestprois2.facade.RolFacade;

/**
 *
 * @author Diego
 */
@Path("/rol")
@Stateless
public class RolController {
    @EJB
    private RolFacade rolFacade;
    
    private static final Logger LOGGER       = Logger.getLogger(UsuarioController.class);
    
    private static final String ROL  = "/{rolId}";
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){
        
        List<Rol> listAllRol =  rolFacade.findAll();
        if(listAllRol.isEmpty()){
            return Response.noContent().build();
        }
        return Response.ok(listAllRol).build();
    }
    
    /**
     * Return a simple Rol by id 
     * @param rolId
     * @return 
     */
    @GET
    @Path(ROL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("rolId") Integer rolId){
        
        Rol usu = rolFacade.find(rolId);
        
        if(usu == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return Response.ok(usu).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveUser(Rol rol){
        try {
            rolFacade.create(rol);
            return Response.created(URI.create("")).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(Rol rol){
        try {
            rolFacade.edit(rol);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
    }
    
    /**
     * 
     * @param rolId
     * @return 
     */
    @DELETE
    @Path(ROL)
    public Response deleteUser(@PathParam("rolId") Integer rolId){
        Rol u = rolFacade.find(rolId);
        rolFacade.remove(u);
        return Response.ok().build();
    }
}
