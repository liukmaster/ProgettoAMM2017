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
import amm.nerdbook.Classi.UtenteRegistrato;
import amm.nerdbook.Classi.UtenteRegistratoFactory;



/**
 *
 * @author fiest_000
 */
public class Login extends HttpServlet {
    public String loggato;
    public String id_loggato;
    
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
        
        postLogin(request,response);
          
        }
    
    
    //creo una sessione solo dopo essere sicuro che l'username e la password siano valide    
    private boolean eseguoLogin(HttpServletRequest request)
            throws ServletException, IOException{
        
      
        /*
          per eseguire il login, devo per prima cosa leggere i dati che sono stati inviati
           name = username, name = password dalla pagina jsp tramite la post
        */
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //faccio un controllo sui dati
        if(username == null && password == null){
            return false;
        }
        
        //dati != da null
        if(username != null && password != null){
            /*
              controllo che l'id dell'utente sia != da -1, se diverso allora è valido
              se uguale a -1 allora i dati username e password sono sbagliati
            */
            int id = loginUtente(username,password);
            if(id>-1){
                
                //creo una sessione 
                HttpSession session = request.getSession();
                //setto loggato a true
                session.setAttribute(loggato,true);
                //setto id_loggato a id controllato (>-1 e valido)
                session.setAttribute(id_loggato,id);
                return true;
            }
            /*
              mentre se i dai inseriti non sono corretti, quindi id= -1
              ritorno al form del login informandolo che i dati inseriti sono erratti
            */
            else{
                return false;
            }  
        }
        else{
            return false;
        } 
        
        
    }
    
    //ciò che avviene dopo aver fatto il login?
    private void postLogin(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        
        //se ho eseguito il login correttamente allora reindirizzo alla bacheca.jsp
        if(eseguoLogin(request) == true){
            request.getRequestDispatcher("bacheca.jsp").forward(request, response);
        }
        /*
          altrimenti setto errori a true e restituisco di nuovo la pagina di login
          quando setto errori a true, sulla jsp controlla se errori è settato a true
          e se lo è restituisce degli errori.
          Possibile implemento di un arrayList per stampare magari che tipo di errori con i rispettivi controlli
        */
        else{
            request.setAttribute("errori", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }   
    }
    
    //controllo che l'username e la password siano corretti, se lo sono restituisco un intero id o -1
    private int loginUtente(String username, String password){
        
        //creo una istanza di urf in modo tale da capire se l'username (email) e la
        //password siano giuste
        UtenteRegistratoFactory u_r_f = UtenteRegistratoFactory.getInstanza();
        
        //scorro gli utenti registrati e faccio il controllo 
        for(UtenteRegistrato ur : u_r_f.getUtentiRegistrati())
            if(username.equals(ur.getEmail()) && password.equals(ur.getPassword())){
                return ur.getId();
            }
        return -1; //dati non esistono o scritti sbagliati
            
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
