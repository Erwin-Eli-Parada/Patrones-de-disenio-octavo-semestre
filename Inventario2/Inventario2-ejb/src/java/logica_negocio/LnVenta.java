/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import accesodatos.VentaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Venta;

/**
 *
 * @author ELI
 */
@Stateless
@LocalBean
public class LnVenta {

    @EJB
    private VentaFacade ventaFacade;

    public void agregar (Venta ta)
    {
        //Agregar a la BD un objeto de la clase abarrote.
        ventaFacade.create(ta);
    }
    
    public List<Venta> ventas(){
        return ventaFacade.findAll();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
