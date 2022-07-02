/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import logica_negocio.LnClientes;
import modelo.Cliente;

/**
 *
 * @author Eli
 */
@Named(value = "control_usuario")
@SessionScoped
public class Control_usuario implements Serializable {

    @EJB
    private LnClientes lnClientes;
    
    private Cliente cliente;
    private List<Cliente> clientes;
    private boolean selectAbarrote=false;
    private boolean seabarrote,editaba,editababoton;

    public Cliente getCliente() {
        return cliente;
    }

    public List<Cliente> getClientes() {
        clientes=lnClientes.getClientes();
        return clientes;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean isSelectAbarrote() {
        return selectAbarrote;
    }
    
    public void editaraba(){
        cliente=lnClientes.idCliente(cliente.getIdcliente());
        seabarrote=true;
        editaba=true;
        editababoton=true;
    }
    
    public boolean isSelectEditar(){
        return editaba;
    }
    
    public void modificarCliente(){
        lnClientes.modifica(cliente);
        seabarrote=false;
        editaba=false;
    }
    
    public void eliminarCliente(){
        lnClientes.elimina(cliente);
        seabarrote=false;
        editaba=false;
    }
    
    public void crear_(){
        cliente= new Cliente();
        getCliente();
    }
    
    /**
     * Creates a new instance of Control_usuario
     */
    public Control_usuario() {
    }
    
}
