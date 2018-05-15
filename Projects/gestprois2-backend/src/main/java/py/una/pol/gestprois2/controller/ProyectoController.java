/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import py.una.pol.gestprois2.entities.Proyecto;
import py.una.pol.gestprois2.facade.ProyectoFacade;

/**
 *
 * @author Diego
 */
@Path("/proyecto")
@Stateless
public class ProyectoController {
    
    @EJB
    private ProyectoFacade proyectoFacade;
    
    private static final String PROJECT = "/{projectId}";
    
    private static final Logger LOGGER = Logger.getLogger(ProyectoController.class);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllProjects(){
        
        List<Proyecto> listPrjects = proyectoFacade.findAll();
        
        if(listPrjects.isEmpty()){
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        
        return Response.ok(listPrjects).build();
    }
    @GET
    @Path(PROJECT)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findProject(@PathParam("projectId")Integer projectId){
        try {
            Proyecto p = proyectoFacade.find(projectId);
            if(p==null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(p).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.serverError().build();
        }
       
    }
}
