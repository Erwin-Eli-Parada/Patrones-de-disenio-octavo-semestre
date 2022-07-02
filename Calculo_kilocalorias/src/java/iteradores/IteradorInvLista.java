/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteradores;

import java.util.Iterator;

/**
 *
 * @author ELI
 */
public class IteradorInvLista implements Iterator{

    private Lista list;
    private int indice;
    
    public IteradorInvLista(Lista l){
        list=l;
        indice=l.elementos.size()-1;
    }
    
    @Override
    public boolean hasNext() {
        return indice>=0;
    }

    @Override
    public Object next() {
        return list.elementos.get(indice--);
    }

    @Override
    public void remove() {
        Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
