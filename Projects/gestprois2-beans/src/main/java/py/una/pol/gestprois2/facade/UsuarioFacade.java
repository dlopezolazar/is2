/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.gestprois2.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import py.una.pol.gestprois2.entities.Usuario;

/**
 *
 * @author Diego
 */
@Stateless
@Named("user")
public class UsuarioFacade extends AbstractFacade<Usuario>{
    @PersistenceContext(name = "gestprois2", unitName = "gestprois2-beansPU", type=PersistenceContextType.TRANSACTION)
    private EntityManager em;

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
