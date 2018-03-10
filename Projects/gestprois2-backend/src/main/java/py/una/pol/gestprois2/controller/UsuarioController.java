/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.controller;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import py.una.pol.gestprois2.facade.UsuarioFacade;

/**
 *
 * @author Diego
 */
@Path("/usuario")
public class UsuarioController {
    @Inject
    private UsuarioFacade usuario;
    
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){
        
        return Response.ok(usuario.findAll()).build();
    }
}