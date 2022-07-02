/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELI
 */
public class RespuestaDirecta extends Reactivo{
    private String[] respuesta;
    private int[] ponderacion;
    public RespuestaDirecta(String pre, String[] res, int[] pon) {
        super(pre, res, pon);
        respuesta=res;
        ponderacion=pon;
        super.aplicacionReactivo=new RespDirecta();
        super.aplicacionReactivo.aplicacion();
        super.calfReactivo= new CalfMultiple();
        super.calfReactivo.calificacion();
        super.revReactivo= new ReviewDirecta();
        super.revReactivo.review();
    }
    
    @Override
    public Double calificacion() {
        //System.out.println("La calificación se obtiene al comparar las respuestas");
        return 0.0;
    }   
}
