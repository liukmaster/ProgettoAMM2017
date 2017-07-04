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

    Post post;

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
        if (Controlli.esistenzaSessione(request)) {
            //restituisco l'utente da visualizzare
            Utente utente = Controlli.getUtente(request);

            List<Utente> amiciutente = UtenteFactory.getInstanza().getUtentiRegistrati();
            if (utente != null) {
                request.setAttribute("utente", utente);
                request.setAttribute("amiciutente", amiciutente);
                request.setAttribute("UtenteLoggato", Controlli.getUtenteLoggato(request));

                List<Gruppo> gruppi = GruppoFactory.getIstanza().allGroups();
                request.setAttribute("gruppiutente", gruppi);

                if (request.getParameter("pubblicapost") != null) {
                    pubblicaPost(request);

                }
                cancellaPost(request);

                List<Post> elencoPost = PostFactory.getIstanza().getPostUtenteList(utente);
                request.setAttribute("posts", elencoPost);
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            request.getRequestDispatcher("Login").forward(request, response);
        }
    }

    public void pubblicaPost(HttpServletRequest request) {

        Utente utente = Controlli.getUtente(request);

        String postditesto = request.getParameter("postditesto");
        String postimmagine = request.getParameter("postimmagine");

        if (postditesto.length() != 0 || postimmagine.length() != 0) {
            post = new Post();
            post.setTestoPost(postditesto);
            post.setImmaginePost(postimmagine);
            if (postimmagine == null || postimmagine.length() == 0) {
                post.setTipoDiPost(Post.Type.TEXT);
            } else {
                post.setTipoDiPost(Post.Type.URL);
            }
            post.setUtente(utente);
            PostFactory.getIstanza().addPost(post);
            request.setAttribute("postpubblicatoconsuccesso", true);
        } else {
            String postvuoto = "Post Vuoto";
            request.setAttribute("postvuoto", postvuoto);
        }
    }

    public void cancellaPost(HttpServletRequest request) {

        String cancellapost = request.getParameter("cancellapost");

        if (cancellapost != null) {
            int delete = Integer.parseInt(cancellapost);
            PostFactory.getIstanza().deletePost(delete);
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
