/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.Utente;
import amm.nerdbook.Classi.UtenteFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fiest_000
 */
public class Controlli extends HttpServlet {

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
        
    }
    
    public static boolean esistenzaSessione(HttpServletRequest request){
        
        HttpSession session = request.getSession();
        if(session.getAttribute("loggato") != null && session.getAttribute("loggato").equals(true)){
            return true;
        }
        else{
            return false;
        }
    }   
    public static Utente getUtenteLoggato(HttpServletRequest request){
            
        //richiamo la sessione esistente
        HttpSession session = request.getSession(false);
        //chiamo il paramentro passato tramite la get
        String user = request.getParameter("user");

        Integer utenteId;
        /*
            se il paramentro è diverso da null vuol dire che è l'id è di un altro account, quindi 
            lo assegno a userID
        */
        if(user != null){
            utenteId = Integer.parseInt(user);
        }
        //se user == null vuol dire che sono loggato e quindi setto userID con l'id dell'utente loggato
        else{
            Integer idUtenteLoggato = (Integer)session.getAttribute("IdUtenteLoggato");
            utenteId = idUtenteLoggato;
        }
        //ritorno l'utente con quel determinato id
        return UtenteFactory.getInstanza().getUtentiRegistratiById(utenteId);
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
