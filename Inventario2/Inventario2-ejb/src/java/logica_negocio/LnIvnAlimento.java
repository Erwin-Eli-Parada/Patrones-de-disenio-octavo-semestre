/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import accesodatos.InvalimentoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Invalimento;

/**
 *
 * @author Eli
 */
@Stateless
@LocalBean
public class LnIvnAlimento {

    @EJB
    private InvalimentoFacade invalimentoFacade;

    public List<Invalimento> getAlimentos() {
        List<Invalimento> lista= invalimentoFacade.findAll();
        List<Invalimento> lista2= new ArrayList<>();
        for(int i=0;i<lista.size();i++){
            if(!lista.get(i).getNombre().contains("DOWN")){
                lista2.add(lista.get(i));
            }
        }
        return lista2;
    }
    
    public Invalimento idabarrote(int ida){
        return invalimentoFacade.find(ida);
    }
    
    public void modifica(Invalimento inva){
        invalimentoFacade.edit(inva);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
