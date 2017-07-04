/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

/**
 * *
 * Il singleton è un design pattern creazionale che ha lo scopo di garantire che
 * di una determinata classe venga creata una e una sola istanza, e di fornire
 * un punto di accesso globale a tale istanza. *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostFactory {

    private static PostFactory singleton;

    public static PostFactory getIstanza() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    /**
     * **** GESTIONE DB, creo la variabile e i rispettivi metodi *****
     */
    private String connectionString;

    //creo un arrayList di post
    public ArrayList<Post> listaPost = new ArrayList<>();

    /*
        l'implementazione prevede che la classe singleton abbia
        un unico costruttore privato, in modo da impedire
        l'istanziazione diretta della classe. 
     */
    private PostFactory() {
    }

    /*
            creo un metodo che restituisce un Post tramite l'id
     */
    public Post getPostById(int id) {
        UtenteFactory utentefactory = UtenteFactory.getInstanza();

        try {
            // path, username, password
            Connection connessione = DriverManager.getConnection(connectionString, "luca", "luca");

            String query = "select * from posts " + "join tipoDiPost on posts.tipo = tipoDiPost.id_tipoDiPost "
                    + "where id_post = ?";

            // Prepared Statement
            PreparedStatement statement = connessione.prepareStatement(query);

            // Si associano i valori
            statement.setInt(1, id);

            // Esecuzione query
            ResultSet result = statement.executeQuery();

            // ciclo sulle righe restituite
            if (result.next()) {
                Post post = new Post();
                //imposto id del post
                post.setId(result.getInt("id_post"));

                //impost il contenuto del post
                post.setTestoPost(result.getString("testoPost"));
                post.setImmaginePost(result.getString("immaginePost"));

                //imposto il tipo del post
                post.setTipoDiPost(this.postTypeFromString(result.getString("nome_tipoDiPost")));

                //imposto l'autore del post
                Utente autore = UtenteFactory.getInstanza().getUtentiRegistratiById(result.getInt("autore"));
                post.setUtente(autore);

                statement.close();
                connessione.close();
                return post;
            }

            statement.close();
            connessione.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }

    /*
            creo un metodo che restituisce una lista dei post degli utenti.
            controllo se l'utente passato al metodo e' uguale a uno degli
            utenti dei post, se lo e' inserisco quel post all'interno della lista
            e la restituisco.
     */
    public List getPostUtenteList(Utente utente) {

        List<Post> listaPost = new ArrayList<>();

        try {
            // path, username, password
            Connection connessione = DriverManager.getConnection(connectionString, "luca", "luca");

            String query = "select * from posts " + "join tipoDiPost on posts.tipo = tipoDiPost.id_tipoDiPost "
                    + "where autore = ?" + " order by id_post desc";

            // Prepared Statement
            PreparedStatement statement = connessione.prepareStatement(query);

            // Si associano i valori
            statement.setInt(1, utente.getId());

            // Esecuzione query
            ResultSet result = statement.executeQuery();

            // ciclo sulle righe restituite
            while (result.next()) {

                Post post = new Post();
                //imposto id del post
                post.setId(result.getInt("id_post"));

                //impost il contenuto del post
                post.setTestoPost(result.getString("testoPost"));
                post.setImmaginePost(result.getString("immaginePost"));

                //imposto il tipo del post
                post.setTipoDiPost(this.postTypeFromString(result.getString("nome_tipoDiPost")));

                //imposto l'autore del post
                post.setUtente(utente);

                listaPost.add(post);
            }

            statement.close();
            connessione.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listaPost;
    }

    public void addPost(Post post) {

        try {
            // path, username, password
            Connection connessione = DriverManager.getConnection(connectionString, "luca", "luca");

            String query = "insert into posts(id_post, testoPost, immaginePost, tipo, autore)"
                    + " values (default, ?, ?, ?, ?)";

            // Prepared Statement
            PreparedStatement statement = connessione.prepareStatement(query);
            // Si associano i valori

            statement.setString(1, post.getContenutoPost());
            statement.setString(2, post.getImmaginePost());
            statement.setInt(3, this.postTypeFromEnum(post.getTipoDiPost()));
            statement.setInt(4, post.getUtente().getId());
            // Esecuzione query
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deletePost(int id) {

        try {
            // path, username, password
            Connection connessione = DriverManager.getConnection(connectionString, "luca", "luca");

            String query = "delete from posts" + " where id_post = ? ";

            // Prepared Statement
            PreparedStatement statement = connessione.prepareStatement(query);
            // Si associano i valori

            statement.setInt(1, id);
            // Esecuzione query
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Post.Type postTypeFromString(String tipo) {

        if (tipo.equals("URL")) {
            return Post.Type.URL;
        }
        return Post.Type.TEXT;
    }

    private int postTypeFromEnum(Post.Type type) {
        //È realizzabile in modo più robusto rispetto all'hardcoding degli indici
        if (type == Post.Type.TEXT) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     ****** GESTIONE DB, creo la variabile e i rispettivi metodi
     *
     * @param s
     */
    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }
}
