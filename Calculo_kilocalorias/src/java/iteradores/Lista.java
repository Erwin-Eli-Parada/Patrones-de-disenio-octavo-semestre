package iteradores;


import java.util.Iterator;
import java.util.LinkedList;
import modelo.Indicadoressalud;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELI
 */
public class Lista{

    public LinkedList <Indicadoressalud> elementos;
    
    public Lista(){
        elementos = new LinkedList<Indicadoressalud>();
    }
    
    public void add(Indicadoressalud is){
        elementos.add(is);
    }
    
    public void imprimir(Iterator il){
        while(il.hasNext())
            System.out.println(((Indicadoressalud)il.next()).toString());
    }
}
