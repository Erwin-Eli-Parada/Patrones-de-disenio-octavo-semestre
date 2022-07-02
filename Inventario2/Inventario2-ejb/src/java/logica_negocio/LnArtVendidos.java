/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import accesodatos.ArtvendidosFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Artvendidos;

/**
 *
 * @author ELI
 */
@Stateless
@LocalBean
public class LnArtVendidos {

    @EJB
    private ArtvendidosFacade artvendidosFacade;

    public void agregar (Artvendidos ta)
    {
        //Agregar a la BD un objeto de la clase abarrote.
        artvendidosFacade.create(ta);
    }
    
    public List<Artvendidos> artVendidos(){
        return artvendidosFacade.findAll();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
