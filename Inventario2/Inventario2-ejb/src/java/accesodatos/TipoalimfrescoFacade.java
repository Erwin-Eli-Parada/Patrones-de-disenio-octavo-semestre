/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Tipoalimfresco;

/**
 *
 * @author Eli
 */
@Stateless
public class TipoalimfrescoFacade extends AbstractFacade<Tipoalimfresco> {

    @PersistenceContext(unitName = "Inventario2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoalimfrescoFacade() {
        super(Tipoalimfresco.class);
    }
    
}
