/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import py.una.pol.gestprois2.entities.Proyecto;
import py.una.pol.gestprois2.entities.Usuario;
import py.una.pol.gestprois2.entities.UsuarioRol;

/**
 *
 * @author Diego
 */
@Stateless
public class UsuarioRolFacade extends AbstractFacade<UsuarioRol>{

    @PersistenceContext(name = "gestprois2", unitName = "gestprois2-beansPU",
    type=PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    public UsuarioRolFacade() {
        super(UsuarioRol.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Usuario findUserInProject(Proyecto project, Usuario user){
        
        try {
            Query query = em
                    .createQuery("SELECT U.usuario FROM UsuarioRol U "
                            + "WHERE U.usuario = :user "
                                     + "AND U.proyecto = :project");
            query.setParameter("user", user);
            query.setParameter("project", project);
            Usuario u = null;
            if(query.getMaxResults() >= 1){
               u = (Usuario) query.getSingleResult();
            }
            
            return u;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    } 
    
}
