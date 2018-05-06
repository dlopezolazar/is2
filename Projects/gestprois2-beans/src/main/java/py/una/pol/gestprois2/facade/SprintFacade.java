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
import py.una.pol.gestprois2.entities.Sprint;

/**
 *
 * @author Diego
 */
@Stateless
public class SprintFacade extends AbstractFacade<Sprint>{

    @PersistenceContext(name = "gestprois2", unitName = "gestprois2-beansPU",
    type=PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    public SprintFacade() {
        super(Sprint.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
