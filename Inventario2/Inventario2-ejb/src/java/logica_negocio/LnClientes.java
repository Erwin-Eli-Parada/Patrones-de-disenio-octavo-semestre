/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica_negocio;

import accesodatos.ClienteFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Cliente;

/**
 *
 * @author Eli
 */
@Stateless
@LocalBean
public class LnClientes {

    @EJB
    private ClienteFacade clienteFacade;
    
    public List<Cliente> getClientes(){
        return clienteFacade.findAll();
    }
    
    public Cliente getCliente(int ic){
        return clienteFacade.find(ic);
    }

    public Cliente getClienteUsuario(String usuario){
        return clienteFacade.findByUsuario(usuario);
    }
    
    public Cliente idCliente(int ida){
        return clienteFacade.find(ida);
    }
    
    public void modifica(Cliente inva){
        clienteFacade.edit(inva);
    }
    
    public void elimina(Cliente c){
        clienteFacade.remove(c);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
