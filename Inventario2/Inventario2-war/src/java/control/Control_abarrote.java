/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import logica_negocio.LnArtVendidos;
import logica_negocio.LnInvAbarrote;
import logica_negocio.LnTAbarrote;
import logica_negocio.LnVenta;
import modelo.Artvendidos;
import modelo.Artvendidos_;
import modelo.Invabarrote;
import modelo.Invalimento;
import modelo.Tipoabarrote;
import modelo.Tipoalimfresco;
import modelo.Venta;

/**
 *
 * @author ELI
 */
@Named(value = "control_abarrote")
@SessionScoped
public class Control_abarrote implements Serializable {

    @EJB
    private LnArtVendidos lnArtVendidos;

    @EJB
    private LnVenta lnVenta;

    @EJB
    private LnTAbarrote lnTAbarrote;

    @EJB
    private LnInvAbarrote lnInvAbarrote;
    
    private Tipoabarrote tabarrote;
    private Invabarrote abarrote;
    private Venta venta;
    private Artvendidos artvendido;
    private List<Invabarrote> abarrotes;
    private List<Tipoabarrote> tabarrotes;
    private List<Venta> ventas;
    private List<Artvendidos> artvendidos;
    private List<Invabarrote> listaabarrotes= new ArrayList<>();
    private List<Integer> cantidades= new ArrayList<>();
    private List<Double> cantidadesTienda= new ArrayList<>();
    private List<Invabarrote> nombreAbarrotes;
    private boolean seabarrote=false; //desahbilitar el control de la seleccion de los elementos y del mismo boton aceptar 
    private boolean editaba=false;
    private boolean editababoton=true;
    
    private double cantidadTienda;
    
    //variables para el mover producto
    private boolean opcionAbarrote=false;
    private boolean opcionAlimento=false;
    private String seleccionarProducto="";
    private List<String> opciones= new ArrayList<>();
    private double cantidad;
    
    //inserto un bean administrador de acceso a datos

    public void agrega_tipo(){
        if(!estatipoa(tabarrote.getNombre())){
            lnTAbarrote.agregar(tabarrote);
            tabarrotes.add(tabarrote);
        }
//        lnTAbarrote.agregar(tabarrote);
        
    }
    
    public void agrega_abarrote()
    {
        if(!estaaba(abarrote.getNombre())){
            lnInvAbarrote.agregar(abarrote);
            abarrotes.add(abarrote);
            seabarrote=false;
            editaba=false;
        }
    }
    
    public void agrega_Venta()
    {
        lnVenta.agregar(venta);
        for(int i=0;i<listaabarrotes.size();i++){
            /*Invabarrote abr=new Invabarrote();
            abr.setIdavr(listaabarrotes.get(i));
            abr.setCantidadtienda(cantidadesTienda.get(i));
            System.out.println(abr.getIdavr());
            System.out.println(abr.getCantidadtienda());*/
            artvendido.setArticulo(listaabarrotes.get(i));
            artvendido.setCantidad(cantidades.get(i));
            artvendido.setVenta(venta);
            lnArtVendidos.agregar(artvendido);
            listaabarrotes.get(i).setCantidadtienda(listaabarrotes.get(i).getCantidadtienda()-cantidades.get(i));
            lnInvAbarrote.modifica(listaabarrotes.get(i));
            seabarrote=false;
            editaba=false;
            editababoton=true;
        }
    }
    
    public void agrega_VentaM()
    {
        lnVenta.agregar(venta);
        for(int i=0;i<listaabarrotes.size();i++){
            /*Invabarrote abr=new Invabarrote();
            abr.setIdavr(listaabarrotes.get(i));
            abr.setCantidadtienda(cantidadesTienda.get(i));
            System.out.println(abr.getIdavr());
            System.out.println(abr.getCantidadtienda());*/
            artvendido.setArticulo(listaabarrotes.get(i));
            artvendido.setCantidad(cantidades.get(i));
            artvendido.setVenta(venta);
            lnArtVendidos.agregar(artvendido);
            listaabarrotes.get(i).setCantidadbodega(listaabarrotes.get(i).getCantidadbodega()-cantidades.get(i));
            lnInvAbarrote.modifica(listaabarrotes.get(i));
            seabarrote=false;
            editaba=false;
            editababoton=true;
        }
    }
    
    private boolean estaaba (String nta)
    {
        boolean esta = false;
        int n = 0;
        for(; n< abarrotes.size() && !abarrotes.get(n).getNombre().equalsIgnoreCase(nta);n++);
        return n<abarrotes.size();
    }
    
    private boolean estatipoa (String nta)
    {
        boolean esta = false;
        int n = 0;
        for(; n< tabarrotes.size() && !tabarrotes.get(n).getNombre().equalsIgnoreCase(nta);n++);
        return n<tabarrotes.size();
    }
    
    public void modificarAbarrote(){
        lnInvAbarrote.modifica(abarrote);
        seabarrote=false;
        editaba=false;
    }
    
    public void editaraba(){
        abarrote=lnInvAbarrote.idabarrote(abarrote.getIdavr());
        seabarrote=true;
        editaba=true;
        editababoton=true;
    }
    
    public Tipoabarrote getTabarrote() {
        return tabarrote;
    }

    public Invabarrote getAbarrote() {
        return abarrote;
    }
    
    public void setAbarrote(Invabarrote abarrote) {
        this.abarrote = abarrote;
    }

    public void setAbarrotes(List<Invabarrote> abarrotes) {
        this.abarrotes = abarrotes;
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
    
    public List<Tipoabarrote> getTabarrotes() {
        tabarrotes = lnTAbarrote.tiposAbarrotes();
        return tabarrotes;
    }
    
    /**
     * Creates a new instance of control_abarrote
     */
    public List<Invabarrote> getAbarrotes() {
        abarrotes = lnInvAbarrote.abarrotes();
        return abarrotes;
    }

    public Control_abarrote(){
//        Tipoabarrote tabarrote = new Tipoabarrote();
//        Invabarrote abarrote = new Invabarrote();
//        abarrotes = new ArrayList<Invabarrote>();
    }

    public void crear_(){
        tabarrote = new Tipoabarrote();
        abarrote = new Invabarrote();
        venta= new Venta();
        artvendido= new Artvendidos();
        //tabarrotes = lnTAbarrote.tiposAbarrotes();
        abarrote.setTipo(tabarrote);
        getTabarrotes();
        getAbarrotes();
        getVentas();
        getArtvendidos();
        //mover producto
        opciones.add("alimento");
        opciones.add("abarrote");
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

    public Artvendidos getArtvendido() {
        return artvendido;
    }

    public List<Artvendidos> getArtvendidos() {
        artvendidos = lnArtVendidos.artVendidos();
        return artvendidos;
    }

    public void setArtvendido(Artvendidos artvendido) {
        this.artvendido = artvendido;
    }

    public void setArtvendidos(List<Artvendidos> artvendidos) {
        this.artvendidos = artvendidos;
    }
    
    public void agrega_alista(){
        //if(getAbarrote().getCantidadtienda()>getArtvendido().getCantidad()){
            listaabarrotes.add(getAbarrote());
            cantidades.add(getArtvendido().getCantidad());
            editababoton=false;
            Invabarrote aba=abarrote;
            for(int i=0;i<abarrotes.size();i++){
                if(abarrotes.get(i).getIdavr()==getAbarrote().getIdavr()){
                    aba=abarrotes.get(i);
                }
            }
            //abarrotes.remove(aba);
        //}
    }

    public List<Invabarrote> getNombreAbarrotes() {
        return nombreAbarrotes;
    }

    public void setNombreAbarrotes(List<Invabarrote> nombreAbarrotes) {
        
        this.nombreAbarrotes = nombreAbarrotes;
    }
    
    public double stockTienda(){
        for(int i=0;i<abarrotes.size();i++){
            if(abarrotes.get(i).getIdavr()==abarrote.getIdavr()){
                cantidadesTienda.add(abarrotes.get(i).getCantidadtienda());
                return abarrotes.get(i).getCantidadtienda();
            }
        }
        return 0;
    }

    public void setCantidadTienda(double cantidadTienda) {
        this.cantidadTienda = cantidadTienda;
    }

    public double getCantidadTienda() {
        return cantidadTienda;
    }
    
    public void establecerAbarrote(){
        for(int i=0;i<abarrotes.size();i++){
            if(abarrote.getIdavr().equals(abarrotes.get(i).getIdavr())){
                abarrote=abarrotes.get(i);
            }
        }
    }
    
    //metodos  mover productos

    public boolean isOpcionAbarrote() {
        return opcionAbarrote;
    }

    public boolean isOpcionAlimento() {
        return opcionAlimento;
    }

    public String getSeleccionarProducto() {
        return seleccionarProducto;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setOpcionAbarrote(boolean opcionAbarrote) {
        this.opcionAbarrote = opcionAbarrote;
    }

    public void setOpcionAlimento(boolean opcionAlimento) {
        this.opcionAlimento = opcionAlimento;
    }

    public void setSeleccionarProducto(String seleccionarProducto) {
        this.seleccionarProducto = seleccionarProducto;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    public void establecerOpcion(){
        if(seleccionarProducto.equals("abarrote")){
            opcionAbarrote=true;
            opcionAlimento=false;
        }else if(seleccionarProducto.equals("alimento")){
            opcionAbarrote=false;
            opcionAlimento=true;
        }
    }
    
    public void moverCantidadAbarrote(){
        if(abarrote.getCantidadbodega()-cantidad>=0){
            abarrote.setCantidadbodega(abarrote.getCantidadbodega()-cantidad);
            abarrote.setCantidadtienda(abarrote.getCantidadtienda()+cantidad);
            lnInvAbarrote.modifica(abarrote);
        }
    }
    
    //metodos de eliminar
    public void eliminarAbarrote(){
        abarrote.setNombre(abarrote.getNombre()+"DOWN");
        lnInvAbarrote.modifica(abarrote);
    }
}
