/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteradores;

import java.util.Iterator;
import java.util.List;
import modelo.Indicadoressalud;

/**
 *
 * @author ELI
 */
public abstract class Iterador implements Iterator{
    protected List<Object> datos;
    protected int vi;
    protected int vf;
    
    Iterador(List d,int vi,int vf){
        datos = d;
        this.vi=vi;
        this.vf=vf;
    }
    
    public abstract Object next();
    
    public abstract boolean hasNext();
}
