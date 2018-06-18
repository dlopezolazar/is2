/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.controller;

import java.net.URI;
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
import py.una.pol.gestprois2.entities.Backlog;

/**
 *
 * @author Diego
 */
@Path("/requerimiento")
@Stateless
public class RequerimientoController {
    
    private static final Logger LOGGER = Logger.getLogger(BacklogController.class);
    
    private static final String REQUERIMIENTO_PROJECT = "/project/{projectId}";
    private static final String REQUERIMIENTO = "/{reqId}";
    
    @GET
    @Path(REQUERIMIENTO_PROJECT)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRequirementsInProject(@PathParam("projectId") Integer projectId){
        
        return Response.ok().build();
    }
    
    /**
     * @param reqgId
     * @return 
     */
    @GET
    @Path(REQUERIMIENTO)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequirement(@PathParam("reqgId") Integer reqgId){
        
        
        return Response.ok().build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveRequirements(Backlog backlog){
        try {
            
            
            
            return Response.created(URI.create("")).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBackLogItem(Backlog backlog){
        try {
            
            
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
    }
    
    /**
     * 
     * @param reqgId
     * @return 
     */
    @DELETE
    @Path(REQUERIMIENTO)
    public Response deleteStory(@PathParam("reqgId") Integer reqgId){
        try {
            
            
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
    }
    
}
