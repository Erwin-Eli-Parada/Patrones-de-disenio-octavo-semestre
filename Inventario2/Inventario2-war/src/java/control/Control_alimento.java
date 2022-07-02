/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import logica_negocio.LnArtVendidos;
import logica_negocio.LnArtVendidosAlim;
import logica_negocio.LnInvAbarrote;
import logica_negocio.LnIvnAlimento;
import logica_negocio.LnTipoAlim;
import logica_negocio.LnVenta;
import modelo.Artvendidos;
import modelo.Artvendidosali;
import modelo.Invalimento;
import modelo.Tipoalimfresco;
import modelo.Venta;

/**
 *
 * @author Eli
 */
@Named(value = "control_alimento")
@SessionScoped
public class Control_alimento implements Serializable {

    @EJB
    private LnVenta lnVenta;

    @EJB
    private LnArtVendidosAlim lnArtVendidosali;
    
    @EJB
    private LnTipoAlim lnTipoAlim;

    @EJB
    private LnIvnAlimento lnIvnAlimento;

    private Tipoalimfresco tipoAlim;
    private Invalimento alimento;
    private Artvendidosali artvendido;
    private Venta venta;
    private List<Venta> ventas;
    private List<Tipoalimfresco> tiposAlim;
    private List<Invalimento> alimentos;
    private List<Artvendidosali> artvendidos;
    private List<Invalimento> listaabarrotes= new ArrayList<>();
    private List<Integer> cantidades= new ArrayList<>();
    private boolean seabarrote=false; //desahbilitar el control de la seleccion de los elementos y del mismo boton aceptar 
    private boolean editaba=false;
    private boolean editababoton=true;
    private int cantidad;

    public Tipoalimfresco getTipoAlim() {
        return tipoAlim;
    }

    public Invalimento getAlimento() {
        return alimento;
    }

    public List<Tipoalimfresco> getTiposAlim() {
        tiposAlim=lnTipoAlim.tiposalimfresco();
        return tiposAlim;
    }

    public List<Invalimento> getAlimentos() {
        alimentos=lnIvnAlimento.getAlimentos();
        return alimentos;
    }
    
    public void setArtvendido(Artvendidosali artvendido) {
        this.artvendido = artvendido;
    }

    public void setArtvendidos(List<Artvendidosali> artvendidos) {
        this.artvendidos = artvendidos;
    }

    public Artvendidosali getArtvendido() {
        return artvendido;
    }

    public List<Artvendidosali> getArtvendidosali() {
        artvendidos = lnArtVendidosali.artVendidos();
        return artvendidos;
    }

    public void setTipoAlim(Tipoalimfresco tipoAlim) {
        this.tipoAlim = tipoAlim;
    }

    public void setAlimento(Invalimento alimento) {
        this.alimento = alimento;
    }

    public void setTiposAlim(List<Tipoalimfresco> tiposAlim) {
        this.tiposAlim = tiposAlim;
    }

    public void setAlimentos(List<Invalimento> alimentos) {
        this.alimentos = alimentos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public boolean isSelectAbarrote(){ //El isSelect es solo para variables booleanas
        return seabarrote;
    }
    
    public boolean isSelectEditar(){
        return editaba;
    }
    
    public boolean isSelectAcpetar(){
        return editababoton;
    }
    
    public void establecerAbarrote(){
        for(int i=0;i<alimentos.size();i++){
            if(alimento.getIdalim().equals(alimentos.get(i).getIdalim())){
                alimento=alimentos.get(i);
            }
        }
    }
    
    public Artvendidosali regresarArticulo(){
        return artvendido;
    }
    
    public void agrega_alista(){
        //if(getAbarrote().getCantidadtienda()>getArtvendido().getCantidad()){
            listaabarrotes.add(getAlimento());
            cantidades.add(getArtvendido().getCantidad());
            editababoton=false;
            Invalimento aba=alimento;
            for(int i=0;i<alimentos.size();i++){
                if(alimentos.get(i).getIdalim()==getAlimento().getIdalim()){
                    aba=alimentos.get(i);
                }
            }
            //alimentos.remove(aba);
        //}
    }
    
    public void editaraba(){
        alimento=lnIvnAlimento.idabarrote(alimento.getIdalim());
        seabarrote=true;
        editaba=true;
        editababoton=true;
    }

    public Venta getVenta() {
        return venta;
    }

    public List<Venta> getVentas() {
        ventas = lnVenta.ventas();
        return ventas;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
    
     public void agrega_Venta()
    {
        lnVenta.agregar(venta);
        for(int i=0;i<listaabarrotes.size();i++){
            //Invalimento abr=new Invalimento();
            //abr.setIdalim(listaabarrotes.get(i));
            artvendido.setArticulo(listaabarrotes.get(i));
            artvendido.setCantidad(cantidades.get(i));
            artvendido.setVenta(venta);
            lnArtVendidosali.agregar(artvendido);
            listaabarrotes.get(i).setCantidadtienda(listaabarrotes.get(i).getCantidadtienda()-cantidades.get(i));
            lnIvnAlimento.modifica(listaabarrotes.get(i));
            seabarrote=false;
            editaba=false;
            editababoton=true;
        }
    }
     
     public void agrega_VentaM()
    {
        lnVenta.agregar(venta);
        for(int i=0;i<listaabarrotes.size();i++){
            //Invalimento abr=new Invalimento();
            //abr.setIdalim(listaabarrotes.get(i));
            artvendido.setArticulo(listaabarrotes.get(i));
            artvendido.setCantidad(cantidades.get(i));
            artvendido.setVenta(venta);
            lnArtVendidosali.agregar(artvendido);
            listaabarrotes.get(i).setCantidadbodega(listaabarrotes.get(i).getCantidadbodega()-cantidades.get(i));
            lnIvnAlimento.modifica(listaabarrotes.get(i));
            seabarrote=false;
            editaba=false;
            editababoton=true;
        }
    }
    /**
     * Creates a new instance of Control_alimento
     */
    public Control_alimento() {
    }
    
    public void crear_(){
        alimento= new Invalimento();
        tipoAlim= new Tipoalimfresco();
        getAlimentos();
        getTiposAlim();
        venta= new Venta();
        artvendido= new Artvendidosali();
        //tabarrotes = lnTAbarrote.tiposAbarrotes();
        alimento.setTipo(tipoAlim);
        getVentas();
        getArtvendidosali();
    
    }
    
    public void moverCantidadAbarrote(){
        if(alimento.getCantidadbodega()-cantidad>=0){
            alimento.setCantidadbodega(alimento.getCantidadbodega()-cantidad);
            alimento.setCantidadtienda(alimento.getCantidadtienda()+cantidad);
            lnIvnAlimento.modifica(alimento);
        }
    }
    
    //metodos de eliminar
    public void eliminarAbarrote(){
        alimento.setNombre(alimento.getNombre()+"DOWN");
        lnIvnAlimento.modifica(alimento);
    }
}
