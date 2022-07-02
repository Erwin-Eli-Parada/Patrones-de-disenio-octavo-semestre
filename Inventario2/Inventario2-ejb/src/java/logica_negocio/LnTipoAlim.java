/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import accesodatos.TipoalimfrescoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Tipoalimfresco;

/**
 *
 * @author Eli
 */
@Stateless
@LocalBean
public class LnTipoAlim {

    @EJB
    private TipoalimfrescoFacade tipoalimfrescoFacade;
    
    public List<Tipoalimfresco> tiposalimfresco() {
         return tipoalimfrescoFacade.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
