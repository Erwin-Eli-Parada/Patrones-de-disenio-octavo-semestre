/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteradores;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author ELI
 */
public class IteradorLista implements Iterator{
    private LinkedList list;
    private int indice=0;
    public IteradorLista(LinkedList la){
        list=la;
    }
    
    @Override
    public boolean hasNext() {
        return indice < list.size();
    }

    @Override
    public Object next() {
        return list.get(indice++);
    }

    @Override
    public void remove() {
        Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
