/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import accesodatos.ArtvendidosaliFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Artvendidosali;

/**
 *
 * @author Eli
 */
@Stateless
@LocalBean
public class LnArtVendidosAlim {

    @EJB
    private ArtvendidosaliFacade artvendidosaliFacade;
    
    public void agregar (Artvendidosali ta)
    {
        //Agregar a la BD un objeto de la clase abarrote.
        artvendidosaliFacade.create(ta);
    }
    
    public List<Artvendidosali> artVendidos(){
        return artvendidosaliFacade.findAll();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
