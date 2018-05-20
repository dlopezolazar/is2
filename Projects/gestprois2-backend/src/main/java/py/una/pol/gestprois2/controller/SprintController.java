/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.controller;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import py.una.pol.gestprois2.entities.Proyecto;
import py.una.pol.gestprois2.entities.Sprint;
import py.una.pol.gestprois2.facade.ProyectoFacade;
import py.una.pol.gestprois2.facade.SprintFacade;
import py.una.pol.gestprois2.model.SprintModel;

/**
 *
 * @author Diego
 */
@Path("/sprint")
@Stateless
public class SprintController {
    
    @EJB
    private SprintFacade sprintFacade;
    
    @EJB
    private ProyectoFacade proyectoFacade;
    
    private static final String SPRINT_ALL = "/{projectId}";
    
    @GET
    @Path(SPRINT_ALL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSttory(@PathParam("projectId") Integer projectId){
        
        Proyecto p = proyectoFacade.find(projectId);
        
        if(p == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        List<Sprint> sprintList = sprintFacade.findAllSprintByProyect(p);
        if(sprintList.isEmpty()){
            return Response.noContent().build();
        }
        SprintModel model = new SprintModel();
        List<SprintModel> listModel = new ArrayList<>();
        for (Sprint sprint : sprintList) {
            model.setSprintId(sprint.getSprintId());
            model.setSprintDescription(sprint.getSprintDescription());
            model.setInitDate(sprint.getFechaInicio());
            model.setEndDate(sprint.getFechaFin());
            model.setProject(sprint.getIdProyecto());
            
            listModel.add(model);
        }
        return Response.ok(listModel).build();
    }
}
