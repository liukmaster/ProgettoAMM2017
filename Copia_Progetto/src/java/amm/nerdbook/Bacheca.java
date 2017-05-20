/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.Gruppo;
import amm.nerdbook.Classi.GruppoFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import amm.nerdbook.Classi.Post;
import amm.nerdbook.Classi.PostFactory;
import amm.nerdbook.Classi.Utente;
import amm.nerdbook.Classi.UtenteFactory;
import java.util.List;

public class Bacheca extends HttpServlet {

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
        
        //setto il tipo di risposta, codice html
        response.setContentType("text/html;charset=UTF-8");
                
        //controllo esistenza sessione
        if(Controlli.esistenzaSessione(request)){
            //restituisco l'utente loggato 
            Utente utente = Controlli.getUtenteLoggato(request);
            
            
            List<Utente> amiciutente = UtenteFactory.getInstanza().getUtentiRegistrati();
            if(utente != null){
                request.setAttribute("utente",utente);
                request.setAttribute("amiciutente",amiciutente);
                
                List<Gruppo> groups = GruppoFactory.getIstanza().ListaGruppi;
                request.setAttribute("gruppiutente", groups);
                
                List<Post> posts = PostFactory.getIstanza().getPostUtenteList(utente);
                request.setAttribute("posts", posts);
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            }
            else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
            
        }
        else {
            request.getRequestDispatcher("Login").forward(request, response);
        }
        
            
    }
    
    /*
    //metodo che restituisce i post dell'utente se diverso da null
    private void listaDeiPostUtente(HttpServletRequest request, HttpServletResponse response){
        
        Utente utente = Controlli.getUtenteLoggato(request);
        if(utente != null){
            request.setAttribute("utente", utente);
        
        }
    */
    
    
        
        
        
        
        
     
    
    
    

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


