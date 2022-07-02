/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import accesodatos.TipoabarroteFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Tipoabarrote;

/**
 *
 * @author ELI
 */
@Stateless
@LocalBean
public class LnTAbarrote {

    @EJB
    private TipoabarroteFacade tipoabarrote;
    public void agregar (Tipoabarrote ta)
    {
        //Agregar a la BD un objeto de la clase abarrote.
        tipoabarrote.create(ta);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public List<Tipoabarrote> tiposAbarrotes() {
         return tipoabarrote.findAll();
    }
}
