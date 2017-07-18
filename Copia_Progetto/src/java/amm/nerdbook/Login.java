/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.GruppoFactory;
import amm.nerdbook.Classi.PostFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import amm.nerdbook.Classi.Utente;
import amm.nerdbook.Classi.UtenteFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

@WebServlet(loadOnStartup = 0)
public class Login extends HttpServlet {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";

    @Override
    public void init() {
        
        //percorso del database
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        //"//localhost:1527/ammdb";
        try {
            // si carica a run-time la classe del Driver tramite il nome del driver stesso
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex){
            /* 
            viene sollevata questa eccezione nel caso
            non si riesca a caricare la classe specificata.
            Il DB in questo caso non sarà utilizzabile,
            potrebbe essere il caso di terminare l’applicazione
            */
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        //IMPOSTO LA CONNECTION STRING PER OGNI FACTORY
        UtenteFactory.getInstanza().setConnectionString(dbConnection);
        PostFactory.getIstanza().setConnectionString(dbConnection);
        GruppoFactory.getIstanza().setConnectionString(dbConnection);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //setto il contenuto, ossia sarà di tipo html
        response.setContentType("text/html;charset=UTF-8");
        faccioLogout(request, response);

        if (eseguoLogin(request)) {
            postLogin(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    //creo una sessione solo dopo essere sicuro che l'username e la password siano valide    
    public boolean eseguoLogin(HttpServletRequest request)
            throws ServletException, IOException {

        //leggo i dati se sono stati inviati
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean sessioneEsistente;
        sessioneEsistente = Controlli.esistenzaSessione(request);
        if (sessioneEsistente == true) {
            return true;
        } else {

            //faccio un controllo sui dati
            if (username == null || password == null) {
                return false;
            }

            int id = UtenteFactory.getInstanza().getIdByUserAndPassword(username, password);
            if (id > -1) {
                //creo una sessione 
                HttpSession session = request.getSession();
                //setto loggato a true
                session.setAttribute("loggato", true);
                //setto id_loggato a id controllato (>-1 e valido)
                session.setAttribute("IdUtenteLoggato", id);
                return true;
            } else {
                request.setAttribute("errori", true);
                return false;
            }
        }
    }

    //eseguo il logout
    private void faccioLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String decisioneLogout = request.getParameter("decisione");
        if (decisioneLogout != null && decisioneLogout.equals("logout")) {
            //imposto il valore false perchè mi permette di ottenere le sessioni solo se queste sono già presenti.
            HttpSession session = request.getSession(false);
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    //ciò che avviene dopo aver fatto il login?
    private void postLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("Profilo").forward(request, response);
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