/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Cliente;

/**
 *
 * @author Eli
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "Inventario2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public Cliente findByUsuario(String login){
        try{
            Query consulta = em.createNamedQuery("Cliente.findByUsuario");
            consulta.setParameter("usuario",login);
            return (Cliente) consulta.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
        
    }
    
}
