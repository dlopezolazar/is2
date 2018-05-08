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
import py.una.pol.gestprois2.entities.Sprint;
import py.una.pol.gestprois2.entities.Story;
import py.una.pol.gestprois2.facade.SprintFacade;
import py.una.pol.gestprois2.facade.StoryFacade;

/**
 *
 * @author Diego
 */
@Path("/story")
@Stateless
public class StoryController {
    @EJB
    private StoryFacade story;
    @EJB
    private SprintFacade sprint;
    
    private static final Logger LOGGER = Logger.getLogger(StoryController.class);
    
    private static final String STORY_ALL = "/{sprintId}";
    
    private static final String STORY     = "/{sprintId}/{storyId}";
    @GET
    @Path(STORY_ALL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSttory(@PathParam("sprintId") Integer sprintId){
        System.out.println("UsuarioController.getAllStoryPerSprint");
        Sprint sp = sprint.find(sprintId);
        
        if(sp == null){
             return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        List<Story> listAllStory =  story.findAllStoryBySprint(sp);
        if(listAllStory.isEmpty()){
            return Response.noContent().build();
        }
        return Response.ok(listAllStory).build();
    }
    
    /**
     * @param sprintId
     * @param storyId
     * @return 
     */
    @GET
    @Path(STORY)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStory(@PathParam("sprintId") Integer sprintId, 
            @PathParam("storyId") Integer storyId){
        
        Story st = story.find(storyId);
        
        if(st == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return Response.ok(st).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveStory(Story st){
        try {
            story.create(st);
            return Response.created(URI.create("")).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStory(Story st){
        try {
            story.edit(st);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
    }
    
    /**
     * 
     * @param userId
     * @return 
     */
    @DELETE
    @Path("/{storyId}")
    public Response deleteStory(@PathParam("storyId") Integer userId){
        Story s = story.find(userId);
        story.remove(s);
        return Response.ok().build();
    }
    
    
}
