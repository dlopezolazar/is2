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
@Path("/backlog")
@Stateless
public class BacklogController {
    
    private static final Logger LOGGER = Logger.getLogger(BacklogController.class);
    
    private static final String BACKLOG_ITEM_PROJECT = "/project/{projectId}";
    private static final String BACKLOG = "/{backlogId}";
    
    @GET
    @Path(BACKLOG_ITEM_PROJECT)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBacklogItemPerProject(@PathParam("projectId") Integer projectId){
        
        return Response.ok().build();
    }
    
    /**
     * @param backlogId
     * @return 
     */
    @GET
    @Path(BACKLOG)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBacklogItem(@PathParam("backlogId") Integer backlogId){
        
        
        return Response.ok().build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveBaclokItem(Backlog backlog){
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
     * @param backlogId
     * @return 
     */
    @DELETE
    @Path(BACKLOG)
    public Response deleteStory(@PathParam("backlogId") Integer backlogId){
        try {
            
            
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
    }
}
