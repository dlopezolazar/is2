/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.controller;

import java.net.URI;
import java.util.ArrayList;
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
import py.una.pol.gestprois2.facade.UsuarioFacade;
import py.una.pol.gestprois2.facade.UsuarioRolFacade;
import py.una.pol.gestprois2.model.SprintModel;
import py.una.pol.gestprois2.model.UserModel;
import py.una.pol.gestprois2.request.StoryRequest;
import py.una.pol.gestprois2.response.StoryResponse;

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
    @EJB
    private UsuarioRolFacade usuarioRol;
    @EJB
    private UsuarioFacade usuario;
    
    private static final Logger LOGGER = Logger.getLogger(StoryController.class);
    
    private static final String STORY_ALL = "/{sprintId}";
    private static final String STORY     = "/{sprintId}/{storyId}";
    
    @GET
    @Path(STORY_ALL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSttory(@PathParam("sprintId") Integer sprintId){
        System.out.println("Story.getAllStoryPerSprint");
        Sprint sp = sprint.find(sprintId);
        
        if(sp == null){
             return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        List<Story> listAllStory =  story.findAllStoryBySprint(sp);
        if(listAllStory.isEmpty()){
            return Response.noContent().build();
        }
        List<StoryResponse> listModel = new ArrayList<>();
        for (Story item : listAllStory) {
            listModel.add(new StoryResponse(
                    item.getIdTarea(), 
                    item.getDescripcion(), 
                    item.getEstado(), 
                    new SprintModel(
                            item.getSprintId().getSprintId(),
                            item.getSprintId().getFechaInicio(), 
                            item.getSprintId().getFechaFin(), 
                            item.getSprintId().getSprintDescription(),
                            item.getSprintId().getIdProyecto()), 
                    new UserModel(
                            item.getIdUsuario().getIdUsuario(),
                            item.getIdUsuario().getCorreo(),
                            item.getIdUsuario().getNombreCompleto())));
        }
        return Response.ok(listModel).build();
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
    public Response saveStory(StoryRequest st){
        try {
            
            if(st.getStoryId() != null){
                return Response.status(Response.Status.FORBIDDEN).build();
            }
            
            Story s = new Story();
            s.setDescripcion(st.getDescripcion());
            s.setEstado(st.getEstado());
            Sprint sp = sprint.find(st.getSprintId());
            if(sp == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            s.setSprintId(sp);
            
            s.setIdUsuario(usuarioRol.findUserInProject(sp.getIdProyecto(), usuario.find(st.getIdUsuario())));
            
            
            story.create(s);
            
            return Response.created(URI.create("")).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStory(StoryRequest st){
        try {
            if(st.getStoryId() == null){
                return Response.status(Response.Status.FORBIDDEN).build();
            }
            
            Story s = new Story();
            s.setIdTarea(st.getStoryId());
            s.setDescripcion(st.getDescripcion());
            s.setEstado(st.getEstado());
            Sprint sp = sprint.find(st.getSprintId());
            if(sp == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            s.setSprintId(sp);
            
            s.setIdUsuario(usuarioRol.findUserInProject(sp.getIdProyecto(), usuario.find(st.getIdUsuario())));

            story.edit(s);
            
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
        try {
            Story s = story.find(userId);
            if(s==null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            story.remove(s);
            
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
    }
    
    
}
