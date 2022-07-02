/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELI
 */
public class OpcionMultipleV extends Reactivo{
    private String[] respuesta;
    private int[] ponderacion;
    public OpcionMultipleV(String pre, String[] res, int[] pon) {
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
        System.out.println("La calificación se obtiene al sumar los correctos");
        return 0.0;
    }   
}
