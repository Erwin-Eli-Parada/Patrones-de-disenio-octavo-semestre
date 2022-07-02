/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Invabarrote;

/**
 *
 * @author ELI
 */
@Stateless
public class InvabarroteFacade extends AbstractFacade<Invabarrote> {

    @PersistenceContext(unitName = "Inventario2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvabarroteFacade() {
        super(Invabarrote.class);
    }
    
}
