/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.Gruppo;
import amm.nerdbook.Classi.GruppoFactory;
import amm.nerdbook.Classi.Utente;
import amm.nerdbook.Classi.UtenteFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fiest_000
 */
public class Profilo extends HttpServlet {

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

        if (Controlli.esistenzaSessione(request)) {
            //restituisco l'utente loggato 
            Utente utente = Controlli.getUtenteLoggato(request);

            List<Utente> amiciutente = UtenteFactory.getInstanza().getUtentiRegistrati();
            if (utente != null) {
                request.setAttribute("UtenteLoggato", utente);
                request.setAttribute("amiciutente", amiciutente);

                List<Gruppo> groups = GruppoFactory.getIstanza().allGroups();
                request.setAttribute("gruppiutente", groups);

                if (request.getParameter("confermaDati") != null) {
                    if (prelevoDatiProfilo(request) == true) {
                        request.setAttribute("risultatoProfilo", "dati inseriti con successo");
                    } else {
                        request.setAttribute("risultatoProfilo", "le password non coincidono!");
                    }
                }

                request.getRequestDispatcher("profilo.jsp").forward(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            request.getRequestDispatcher("Login").forward(request, response);
        }
    }

    public boolean prelevoDatiProfilo(HttpServletRequest request) {

        String nomeUtente = request.getParameter("nomeUtente");
        String cognomeUtente = request.getParameter("cognomeUtente");
        String dataDiNascita = request.getParameter("dataDiNascita");
        String frasePresentazione = request.getParameter("frasePresentazione");
        String password = request.getParameter("password");
        String confermaPassword = request.getParameter("confermaPassword");

        Utente utente = Controlli.getUtenteLoggato(request);

        if (password.equals(confermaPassword)){
            
            UtenteFactory.getInstanza().setDatiProfilo(nomeUtente, cognomeUtente, dataDiNascita, password, frasePresentazione, utente.getId());
            return true;
        } else {
            return false;
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
