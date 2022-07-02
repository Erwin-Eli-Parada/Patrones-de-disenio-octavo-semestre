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
public class IteradorSimple extends Iterador{
    
    int indice;
    
    private Iterator iterador;
    
    public IteradorSimple(List<Indicadoressalud> list){
        super(list, 0, list.size());
        iterador = list.iterator();
    }

    @Override
    public Object next() {
        return iterador.next();
    }

    @Override
    public boolean hasNext() {
        return iterador.hasNext();
    }
    
}
