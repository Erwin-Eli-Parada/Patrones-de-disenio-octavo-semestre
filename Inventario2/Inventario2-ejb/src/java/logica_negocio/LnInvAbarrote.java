/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import accesodatos.InvabarroteFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Invabarrote;

/**
 *
 * @author ELI
 */
@Stateless
@LocalBean
public class LnInvAbarrote {

    @EJB
    private InvabarroteFacade invabarrote;

    public void agregar (Invabarrote ia)
    {
        //Agregar a la BD un objeto de la clase abarrote.
        invabarrote.create(ia);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<Invabarrote> abarrotes(){
        List<Invabarrote> lista= invabarrote.findAll();
        List<Invabarrote> lista2= new ArrayList<>();
        for(int i=0;i<lista.size();i++){
            if(!lista.get(i).getNombre().contains("DOWN")){
                lista2.add(lista.get(i));
            }
        }
        return lista2;

    }
    
    public Invabarrote idabarrote(int ida){
        return invabarrote.find(ida);
    }
    
    public void modifica(Invabarrote inva){
        invabarrote.edit(inva);
    }
}
