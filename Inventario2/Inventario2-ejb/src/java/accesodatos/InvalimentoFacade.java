/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Invalimento;

/**
 *
 * @author Eli
 */
@Stateless
public class InvalimentoFacade extends AbstractFacade<Invalimento> {

    @PersistenceContext(unitName = "Inventario2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvalimentoFacade() {
        super(Invalimento.class);
    }
    
}
