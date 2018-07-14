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
import py.una.pol.gestprois2.entities.Usuario;

/**
 *
 * @author Diego
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(name = "gestprois2", unitName = "gestprois2-beansPU",
    type=PersistenceContextType.TRANSACTION)
    private EntityManager em;

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Usuario validateUser(String user, String password){  
        try {
            Query query = em
                    .createQuery("SELECT U FROM Usuario U "
                            + "WHERE (U.correo = :user OR U.uid = :user)"
                                     + "AND U.password = :pass");
            query.setParameter("user", user);
            query.setParameter("pass", password);
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
    
    public Usuario findUserByUid(String uid){
        Query query = em.
                createQuery("SELECT U FROM Usuario U "
                        + "WHERE U.uid = :uid");
        query.setParameter("uid", uid);
        
        Usuario u = null;
        if(query.getMaxResults() >= 1){
            u = (Usuario) query.getSingleResult();
        }

        return u;
    }
}
