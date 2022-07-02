
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELI
 */
public class UnidadGeopoliticaAgrupada extends UnidadGeopolitica{
    private ArrayList<UnidadGeopolitica> geopolitica;
    
    public UnidadGeopoliticaAgrupada(String nombre){
        super.nombre=nombre;
        geopolitica=new ArrayList<UnidadGeopolitica>();
    }
    
    @Override
    public void add(UnidadGeopolitica ug){
        if(!geopolitica.contains(ug)){
            geopolitica.add(ug);
        }
    }
    
    @Override
    public void remover(UnidadGeopolitica ug){
        geopolitica.remove(ug);
    }
    
    @Override
    public UnidadGeopolitica buscar(String nombre){
        UnidadGeopolitica res=null;
        for(int i=0;i<geopolitica.size();i++){
            if(geopolitica.get(i).nombre().equalsIgnoreCase(nombre)){
                res=geopolitica.get(i);
                break;
            }
        }
        return res;
    }
    
    @Override
    public void listar(){
        System.out.print("nombre: " + super.nombre()+"\n"); // los datos de la unidad 
        Iterator iterador = geopolitica.iterator();
              while(iterador.hasNext())
             {
                 UnidadGeopolitica eug= (UnidadGeopolitica) iterador.next();
                 eug.listar();
             }

    }
}
