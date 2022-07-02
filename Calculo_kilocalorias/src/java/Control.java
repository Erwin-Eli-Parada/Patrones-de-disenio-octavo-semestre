/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import accesobd.IndicadoressaludJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import modelo.Indicadoressalud;
import modelo.Tipoactividad;
import modelo.Usuario;

/**
 *
 * @author ELI
 */
@WebServlet(urlPatterns = {"/Control"})
public class Control extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    private double icc,imc=0;
    
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
        
        HttpSession sesionActual = request.getSession(true);
        
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        
        RequestDispatcher control = request.getRequestDispatcher("resultados.jsp");
        
        Indicadoressalud indicadoressalud = new Indicadoressalud();
        indicadoressalud.setCadera(Integer.parseInt(request.getParameter("cadera")));
        indicadoressalud.setCintura(Integer.parseInt(request.getParameter("cintura")));
        indicadoressalud.setPeso(Double.parseDouble(request.getParameter("peso")));
        indicadoressalud.setFecha(date);
        Tipoactividad ta = new Tipoactividad();
        ta.setIdtac(Integer.parseInt(request.getParameter("tipoactividad")));
        indicadoressalud.setTipoactividad(ta);
        Usuario u= (Usuario)sesionActual.getAttribute("usuario");
        //Usuario u= new Usuario();
        //u.setIdusuario(Integer.parseInt(request.getParameter("id")));
        indicadoressalud.setUsuario(u);
        try {
            
            sesionActual.setAttribute("is",indicadoressalud);
            icc=Double.parseDouble(request.getParameter("cintura"))/Double.parseDouble(request.getParameter("cadera"));
            imc=indicadoressalud.getPeso()/(Double.parseDouble(request.getParameter("estatura"))*Double.parseDouble(request.getParameter("estatura")));
            sesionActual.setAttribute("icc",icc);
            sesionActual.setAttribute("imc",imc);
            //sesionActual.setAttribute("isc", isc.findIndicadoressaludEntities());
            control.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Control</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Control at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
