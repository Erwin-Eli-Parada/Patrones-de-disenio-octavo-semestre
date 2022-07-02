/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import accesobd.TipoactividadJpaController;
import accesobd.UsuarioJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
import modelo.Tipoactividad;
import modelo.Usuario;

/**
 *
 * @author ELI
 */
@WebServlet(urlPatterns = {"/Acceso"})
public class Acceso extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    private int numIntentos=0;
    private boolean banner=false;
    
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
        
        RequestDispatcher acceso = request.getRequestDispatcher("obtenerDatos.jsp");
        RequestDispatcher inicio = request.getRequestDispatcher("index.jsp");
        
        emf= Persistence.createEntityManagerFactory("Calculo_kilocaloriasPU");
        UsuarioJpaController cu;
        cu= new UsuarioJpaController(utx, emf);
        List<Usuario> usuarios= cu.findUsuarioEntities();
        
        TipoactividadJpaController tca;
        tca = new TipoactividadJpaController(utx, emf);
        List<Tipoactividad> actividades = tca.findTipoactividadEntities();
        
        String nombreUsuario= request.getParameter("nombreUsuario");
        String clave =request.getParameter("clave");
        
        HttpSession sesionActual = request.getSession(true);
        sesionActual.setAttribute("in", numIntentos++);
        /*
        sesionActual.setAttribute("act1",actividades.get(0).getActividades());
        sesionActual.setAttribute("act2",actividades.get(1).getActividades());
        sesionActual.setAttribute("act3",actividades.get(2).getActividades());
        sesionActual.setAttribute("act4",actividades.get(3).getActividades());
        sesionActual.setAttribute("des1",actividades.get(0).getDescripcion());
        sesionActual.setAttribute("des2",actividades.get(1).getDescripcion());
        sesionActual.setAttribute("des3",actividades.get(2).getDescripcion());
        sesionActual.setAttribute("des4",actividades.get(3).getDescripcion());*/
        
        //if(numIntentos>5) sesionActual.invalidate();
        if(usuarios.isEmpty()){
            inicio.forward(request, response);
        }
        
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombre().equalsIgnoreCase(nombreUsuario) && usuarios.get(i).getContrasenia().equals(clave)) {
                sesionActual.setAttribute("usuario", usuarios.get(i));
                sesionActual.setAttribute("actividades", actividades);
                acceso.forward(request, response);
                banner=true;
            }
        }
        
        if(!banner){
            inicio.forward(request, response);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Acceso</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Acceso at " +"" + "</h1>");
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
