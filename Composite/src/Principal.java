/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELI
 */
public class Principal {
    public static void main(String[] args){
        NumHab nh1= new NumHab(1000, 2022);
        NumHab nh2= new NumHab(2000, 2022);
        NumHab nh3= new NumHab(3000, 2022);
        
        UnidadGeopolitica region_1 = new UnidadGeopoliticaAgrupada ("Valles Centrales");
        UnidadGeopolitica region_2 = new UnidadGeopoliticaAgrupada ("Sierra sur");
        
        UnidadGeopolitica municipio_1 = new UnidadGeopoliticaAgrupada ("Oaxaca De Juarez");
        UnidadGeopolitica municipio_2 = new UnidadGeopoliticaAgrupada ("San Pablo etla");
        UnidadGeopolitica municipio_3 = new UnidadGeopoliticaAgrupada ("Santa Lucia Miahuatlan");
        
        UnidadGeopolitica localidad_1 = new Localidad ("localidad 1",1000,nh1);
        UnidadGeopolitica localidad_2 = new Localidad ("localidad 2",2000,nh2);
        UnidadGeopolitica localidad_3 = new Localidad ("localidad 3",3000,nh3);
        
        region_1.add(municipio_1);
        region_1.add(municipio_2);
        region_2.add(municipio_3);
        
        municipio_1.add(localidad_1);
        municipio_2.add(localidad_2);
        municipio_3.add(localidad_3);
        
        region_1.listar();
    }
}
