/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELI
 */
public abstract class UnidadGeopolitica {
    protected String nombre;
    protected int extension;
    protected NumHab numHab;
    
    public int numHabi(){
        return numHab.numhab();
    }
    
    public String nombre(){
        return nombre;
    }
    
    public int extension(){
        return extension;
    }
    
    public void add(UnidadGeopolitica ug){
        
    }
    
    public void remover(UnidadGeopolitica ug){
        
    }
    
    public UnidadGeopolitica buscar(String nombre){
        return null;
    }
    
    public void listar(){
        
    }
}
