
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELI
 */
public abstract class Reactivo {
    protected String pregunta;
    protected String[] respuestas;
    protected int[] ponderacion;
    /*private AplicacionReactivo opcionMultiple = new OpcionMultiple();
    private AplicacionReactivo respDirecta = new RespDirecta();
    private AplicacionReactivo relacion = new Relacion();
    */
    protected AplicacionReactivo aplicacionReactivo;
    protected CalificacionReactivo calfReactivo;
    protected ReviewReactivo revReactivo;
    protected String[] respuestasAlumno;
    public Reactivo(String pre, String[] res,int[] pon){
        pregunta=pre;
        respuestas=res;
        ponderacion=pon;
    }
    
    public AplicacionReactivo formaAplicacion(){
        return aplicacionReactivo;
    }
    
    public CalificacionReactivo formaCalificacion(){
        return calfReactivo;
    }
    
    public ReviewReactivo formaReview(){
        return revReactivo;
    }
    
    public void aplicacion(){
        //aplicacionReactivo.aplicacion();
    }
    abstract public Double calificacion(); 
}
