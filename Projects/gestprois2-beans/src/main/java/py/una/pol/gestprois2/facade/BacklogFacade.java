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
import py.una.pol.gestprois2.entities.Backlog;

/**
 *
 * @author Diego
 */
@Stateless
public class BacklogFacade extends AbstractFacade<Backlog>{
    
    @PersistenceContext(name = "gestprois2", unitName = "gestprois2-beansPU",
    type=PersistenceContextType.TRANSACTION)
    private EntityManager em;

    public BacklogFacade() {
        super(Backlog.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
