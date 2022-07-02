/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import accesobd.IndicadoressaludJpaController;
import iteradores.Iterador;
import iteradores.IteradorCintura;
import iteradores.IteradorPeso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import modelo.Indicadoressalud;
import modelo.Usuario;

/**
 *
 * @author ELI
 */
@WebServlet(urlPatterns = {"/ControlTablaMediciones"})
public class ControlTablaMediciones extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        emf = Persistence.createEntityManagerFactory("AppWebCaloriasPU");
        IndicadoressaludJpaController control_indi = new IndicadoressaludJpaController(utx, emf);
        HttpSession sesion = request.getSession(true);
        Usuario persona = (Usuario) sesion.getAttribute("usuario");
        Indicadoressalud in= (Indicadoressalud) control_indi.findIndicadoressaludEntities();
        Indicadoressalud indi = (Indicadoressalud) sesion.getAttribute("indi");
        String n = "1";
        try (PrintWriter out = response.getWriter()){
            Iterador iterator = new IteradorCintura((List<Indicadoressalud>) in, 0, 5);
            response.setContentType("text/html;charset-UTF-8");
            out.println("<!DOCTYPE html>");
            out.println( "<html>");
            out.println( "<head>");
            out.println( "<title> Title  </title>");
            out.println( "</head>");
            out.println( "<body>"
                      + "<center>"
                      + "<h3>Lista de medidas de la persona " + persona.getNombre()  + "</h3>"
                      + "<form action=''>"
                        + "<select name=\"ordenar\">\n"
                        + "    <option value='1'>Normal</option>\n"
                        + "    <option value='2'>Inverso</option>\n"
                        + "</select>"
                        + "<button type='submit'> Mostrar </button>"
                      + "</form>"
                      + "<br>");
            n = request.getParameter("ordenar");
            if(Integer.parseInt(n) == 2)
                iterator = new IteradorPeso(indi, 0, in.size());
            out.println("<table sytle='border: 1px solid black;' >"
                      + " <thead>"
                      + "  <tr>"
                      + "    <th style='border: 1px solid black;'>Fecha</th>"
                      + "    <th style='border: 1px solid black;'>Peso</th>"
                      + "    <th style='border: 1px solid black;'>Cintura</th>"
                      + "    <th style='border: 1px solid black;'>Cadera</th>"
                      + "    <th style='border: 1px solid black;'>Actividad</th>"
                      + "  </tr>"
                      + " </thead>");
            out.println("<tbody>");
            while(iterator.hasNext()){
                indi= (Indicadoressalud) iterator.next();
                out.println("<tr>" 
                          + "  <th style='border: 1px solid black;'>"+ indi.getFecha() +"</th>"
                          + "  <th style='border: 1px solid black;'>"+ indi.getPeso() +"</th>"
                          + "  <th style='border: 1px solid black;'>"+ indi.getCintura() +"</th>"
                          + "  <th style='border: 1px solid black;'>"+ indi.getCadera() +"</th>"
                          + "  <th style='border: 1px solid black;'>"+ indi.getIdindsalud() +"</th>"
                          + "</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
        } catch (Exception ex) {
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
