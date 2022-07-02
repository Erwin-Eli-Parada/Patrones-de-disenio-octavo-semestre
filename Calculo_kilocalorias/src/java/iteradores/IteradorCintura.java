/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteradores;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import modelo.Indicadoressalud;

/**
 *
 * @author ELI
 */
public class IteradorCintura extends Iterador implements Comparator<Indicadoressalud>{

    private int index = 0;
    
    public IteradorCintura(List<Indicadoressalud> d, int vi, int vf) {
        super(d, vi, vf);
        Collections.sort(d, this);
    }

    @Override
    public Object next() {
        return super.datos.get(index++);
    }

    @Override
    public boolean hasNext() {
        return (index < super.datos.size() && super.datos.get(index) != null && super.vi <= super.vf);

    }

    @Override
    public int compare(Indicadoressalud t, Indicadoressalud t1) {
        return t.getCintura().compareTo(t1.getCintura());
    }
    
}
