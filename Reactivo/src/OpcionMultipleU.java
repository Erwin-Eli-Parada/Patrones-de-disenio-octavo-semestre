/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELI
 */
public class OpcionMultipleU extends Reactivo{
    private String[] respuesta;
    private int[] ponderacion;
    public OpcionMultipleU(String pre, String[] res, int[] pon) {
        super(pre, res, pon);
        respuesta=res;
        ponderacion=pon;
        super.aplicacionReactivo=new OpcionMultiple();
        super.aplicacionReactivo.aplicacion();
        super.calfReactivo= new CalfMultiple();
        super.calfReactivo.calificacion();
        super.revReactivo= new ReviewMultiple();
        super.revReactivo.review();
    }
    
    @Override
    public Double calificacion() {
        /*double calf=0.0;
        for(int i=0;i<ponderacion.length;i++){
            calf+=ponderacion[i];
        }
        return calf;/*
        */
        //System.out.println("La calificación se obtiene al checar el correcto");
        return 0.0;
    }   
    
}
