/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import py.una.pol.gestprois2.entities.Sprint;
import py.una.pol.gestprois2.entities.Story;

/**
 *
 * @author Diego
 */
@Stateless
public class StoryFacade extends AbstractFacade<Story>{

    @PersistenceContext(name = "gestprois2", unitName = "gestprois2-beansPU",
    type=PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    public StoryFacade() {
        super(Story.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Story> findAllStoryBySprint(Sprint sprint){
        
        try {
            Query query = em.createQuery("SELECT S FROM Sprint S "
                    + "WHERE S.sprintId = :sprint ");
            query.setParameter("sprint", sprint);
            
            List<Story> storyList = query.getResultList();
            
            return storyList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
}
