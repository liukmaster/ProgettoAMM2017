/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import amm.nerdbook.Classi.Utente;
import amm.nerdbook.Classi.UtenteFactory;

/**
 *
 * @author fiest_000
 */
public class Login extends HttpServlet {
       
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
        
        //setto il contenuto, ossia sarà di tipo html
        response.setContentType("text/html;charset=UTF-8");
        faccioLogout(request,response);
        
        if(eseguoLogin(request)){
            postLogin(request,response);
        }
        else {
            request.setAttribute("errori", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } 
    }
    
    //creo una sessione solo dopo essere sicuro che l'username e la password siano valide    
    public boolean eseguoLogin(HttpServletRequest request)
            throws ServletException, IOException{
        
        //leggo i dati se sono stati inviati
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        boolean sessioneEsistente;
        sessioneEsistente = Controlli.esistenzaSessione(request);
        if(sessioneEsistente == true)
            return true;
        else{
            
            //faccio un controllo sui dati
            if(username == null || password == null){
                return false;
            }
            
            int id = loginUtente(username,password);
            if(id>-1){
                
                //creo una sessione 
                HttpSession session = request.getSession();
                //setto loggato a true
                session.setAttribute("loggato",true);
                //setto id_loggato a id controllato (>-1 e valido)
                session.setAttribute("IdUtenteLoggato",id);
                return true;
            }
            else{
                return false;
            }
        }
    }
    //eseguo il logout
    private void faccioLogout(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
         
         String decisioneLogout = request.getParameter("decisione");
         if(decisioneLogout != null && decisioneLogout.equals("logout")){
            
            /*
                Imposto il valore false perchè mi permette di ottenere
                le sessioni solo se queste sono già presenti.
            */
            HttpSession session = request.getSession(false);
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    
    //ciò che avviene dopo aver fatto il login?
    private void postLogin(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        request.getRequestDispatcher("Bacheca").forward(request, response);
    }
    
    //controllo che l'username e la password siano corretti, se lo sono restituisco un intero id o -1
    private int loginUtente(String username, String password){
        
        //creo una istanza di urf in modo tale da capire se l'username (email) e la
        //password siano corrette
        UtenteFactory u_f = UtenteFactory.getInstanza();
        
        //scorro gli utenti registrati e faccio il controllo
        for (Utente ur : u_f.getUtentiRegistrati()) {
            if(username.equals(ur.getEmail()) && password.equals(ur.getPassword())){
                return ur.getId();
                
            }
        }
        return -1; //dati inesistenti o non corretti           
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
