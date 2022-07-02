/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import logica_negocio.LnClientes;
import modelo.Cliente;

/**
 *
 * @author Eli
 */
@Named(value = "control_acceso")
@SessionScoped
public class Control_acceso implements Serializable {

    @EJB
    private LnClientes lnClientes;

    private Cliente cliente;
    private String paginaDestino = "";
    private boolean activo1=false, activo2=false, activo3=false;
    /**
     * Creates a new instance of Control_acceso
     */
    public Control_acceso() {
        cliente = new Cliente();
        paginaDestino = "";
    }
    
    
     public void acceso() {
         
        try {
            Cliente c2 = lnClientes.getClienteUsuario(cliente.getUsuario());
            paginaDestino = "";
            System.out.println(c2.getUsuario());
            System.out.println(cliente.getUsuario());
            if (c2 != null) {
                if (c2.getPassword().equals(cliente.getPassword())) {
                    if(c2.getTipocliente()==1){
                        activo1=true;
                        activo2=true;
                        activo3=true;
                    }else if(c2.getTipocliente()==2){
                        activo1=false;
                        activo2=true;
                        activo3=false;
                    }else{
                        activo1=false;
                        activo2=false;
                        activo3=true;
                    }
                    paginaDestino = "indexTemplate";
                } else {
                    System.out.println("contraseña incorrecta");
                }

            } else {
                System.out.println("no hay usuario");
            }
        } catch (Exception e) {

        }

    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getPaginaDestino() {
        return paginaDestino;
    }

    public boolean isActivo1() {
        return activo1;
    }

    public boolean isActivo2() {
        return activo2;
    }

    public boolean isActivo3() {
        return activo3;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPaginaDestino(String paginaDestino) {
        this.paginaDestino = paginaDestino;
    }

    public String PaginaDestino() {
        return paginaDestino;
    }
    
    
}
