/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/** *
 * Il singleton è un design pattern creazionale che ha lo scopo di garantire che di
 * una determinata classe venga creata una e una sola istanza, e di fornire un punto
 * di accesso globale a tale istanza.
 ** */
package amm.nerdbook.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtenteFactory {

    private static UtenteFactory singleton;

    public static UtenteFactory getInstanza() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }

    /**
     * ** GESTIONE DB, creo la variabile e i rispettivi metodi ***
     */
    private String connectionString;

    /*
        l'implementazione prevede che la classe singleton abbia
        un unico costruttore privato, in modo da impedire
        l'istanziazione diretta della classe. 
     */
    private UtenteFactory() {
    }

    /*
        scorro la lista degli utenti registrati e restituisco l'utente 
         se l'id inserito tramite il metodo e' uguale a uno degli id degli utenti 
        presenti, allora restituisco l'utente
     */
    public Utente getUtentiRegistratiById(int id) {

        try {
            /*  
                per ottenere una connessione invoco un metodo della classe DriverManager.
                connectionString = localizzazione punto di accesso al DB (URL)
                luca = username del DB
                luca = password del DB
             */
            Connection connessione = DriverManager.getConnection(connectionString, "luca", "luca");

            //preparo una stringa che contiene la query,
            //I punti interrogativi sono i valori che saranno conosciuti a runtime dall'applicazione 
            String query = "select * from utente" + " where utente_id = ?";
            /*
                Una volta ottenuta una connessione,
                si può operare sul DB con query di selezione
                e query di comando (UPDATE, DELETE, INSERT…)
                    -per far questo si ricorre all’interfaccia java.sql.Statement                     
                    -Uno statement viene ottenuto dall’oggetto connessione:
             */

            //I PreparedStatement sono degli Statement quasi completi
            //ai quali dobbiamo passare dei parametri, anche a run-time
            PreparedStatement statement = connessione.prepareStatement(query);
            // Si associano i valori, prevengo l'sql injection
            statement.setInt(1, id);

            /*
            executeQuery(String) ----> metodo usato per eseguire interrogazioni al DB (SELECT)
            executeUpdate(String)----> metodo usato per inserimenti, aggiornamenti e cancellazioni (INSERT, UPDATE, DELETE).
             */
            //Il metodo executeQuery(String) restituisce un ResultSet , un oggetto-tabella 
            //che rappresenta i dati selezionati dalla nostra interrogazione
            ResultSet result = statement.executeQuery();

            //ciclo sulle righe della tabella restituite
            if (result.next()) {
                Utente utente = new Utente();
                utente.setId(result.getInt("utente_id"));
                utente.setNome(result.getString("nome"));
                utente.setCognome(result.getString("cognome"));
                utente.setEmail(result.getString("email"));
                utente.setPassword(result.getString("password"));
                utente.setUrlFotoProfilo(result.getString("urlFotoProfilo"));
                utente.setDataDiNascita(result.getString("dataDiNascita"));
                utente.setFrasePresentazione(result.getString("frasePresentazione"));

                //chiudo lo statement, chiudo la connessione e infine ritorno l'utente
                statement.close();
                connessione.close();
                return utente;
            }
            //chiudo lo statement, chiudo la connessione
            statement.close();
            connessione.close();
            // nel caso la query fallisca
            // viene sollevata una SQLException
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public int getIdByUserAndPassword(String username, String password) {
        try {
            /*  
                per ottenere una connessione invoco un metodo della classe DriverManager.
                connectionString = localizzazione punto di accesso al DB (URL)
                luca = username del DB
                luca = password del DB
             */
            Connection connessione = DriverManager.getConnection(connectionString, "luca", "luca");

            //preparo una stringa che contiene la query,
            //I punti interrogativi sono i valori che saranno conosciuti a runtime dall'applicazione 
            String query = "select utente_id from utente" + " where email = ? and password = ?";

            /*
                Una volta ottenuta una connessione,
                si può operare sul DB con query di selezione
                e query di comando (UPDATE, DELETE, INSERT…)
                    -per far questo si ricorre all’interfaccia java.sql.Statement                     
                    -Uno statement viene ottenuto dall’oggetto connessione:
             */
            //I PreparedStatement sono degli Statement quasi completi
            //ai quali dobbiamo passare dei parametri, anche a run-time
            PreparedStatement statement = connessione.prepareStatement(query);

            // Si associano i valori, prevengo l'sql injection
            statement.setString(1, username);
            statement.setString(2, password);

            /*
            executeQuery(String) ----> metodo usato per eseguire interrogazioni al DB (SELECT)
            executeUpdate(String)----> metodo usato per inserimenti, aggiornamenti e cancellazioni (INSERT, UPDATE, DELETE).
             */
            //Il metodo executeQuery(String) restituisce un ResultSet , un oggetto-tabella 
            //che rappresenta i dati selezionati dalla nostra interrogazione
            ResultSet result = statement.executeQuery();

            //ciclo sulle righe della tabella restituite
            if (result.next()) {
                int id = result.getInt("utente_id");

                //chiudo lo statement, chiudo la connessione e infine ritorno l'utente
                statement.close();
                connessione.close();
                return id;
            }

            statement.close();
            connessione.close();
            // nel caso la query fallisca
            // viene sollevata una SQLException    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    public List<Utente> getUtentiRegistrati() {

        List<Utente> listaUtentiRegistrati = new ArrayList<>();
        try {
            /*  
                per ottenere una connessione invoco un metodo della classe DriverManager.
                connectionString = localizzazione punto di accesso al DB (URL)
                luca = username del DB
                luca = password del DB
             */
            Connection connessione = DriverManager.getConnection(connectionString, "luca", "luca");

            //preparo una stringa che contiene la query
            String query = "select * from utente";

            /*
                Una volta ottenuta una connessione,
                si può operare sul DB con query di selezione
                e query di comando (UPDATE, DELETE, INSERT…)
                    -per far questo si ricorre all’interfaccia java.sql.Statement                     
                    -Uno statement viene ottenuto dall’oggetto connessione:
             */
            //I PreparedStatement sono degli Statement quasi completi
            //ai quali dobbiamo passare dei parametri, anche a run-time
            PreparedStatement statement = connessione.prepareStatement(query);

            /*
            executeQuery(String) ----> metodo usato per eseguire interrogazioni al DB (SELECT)
            executeUpdate(String)----> metodo usato per inserimenti, aggiornamenti e cancellazioni (INSERT, UPDATE, DELETE).
             */
            //Il metodo executeQuery(String) restituisce un ResultSet , un oggetto-tabella 
            //che rappresenta i dati selezionati dalla nostra interrogazione
            ResultSet result = statement.executeQuery();

            // ciclo sulle righe della tabella restituite
            while (result.next()) {
                Utente utente = new Utente();
                utente.setId(result.getInt("utente_id"));
                utente.setNome(result.getString("nome"));
                utente.setCognome(result.getString("cognome"));
                utente.setEmail(result.getString("email"));
                utente.setPassword(result.getString("password"));
                utente.setUrlFotoProfilo(result.getString("urlFotoProfilo"));
                utente.setDataDiNascita(result.getString("dataDiNascita"));
                utente.setFrasePresentazione(result.getString("frasePresentazione"));

                listaUtentiRegistrati.add(utente);
            }

            //chiudo lo statement, chiudo la connessione e infine ritorno l'utente
            statement.close();
            connessione.close();
            // nel caso la query fallisca
            // viene sollevata una SQLException 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listaUtentiRegistrati;
    }

    public List getUtentiList(String nome) {
        List<Utente> listaUtentiRegistrati = new ArrayList<>();

        try {
            /*  
                per ottenere una connessione invoco un metodo della classe DriverManager.
                connectionString = localizzazione punto di accesso al DB (URL)
                luca = username del DB
                luca = password del DB
             */
            Connection connessione = DriverManager.getConnection(connectionString, "luca", "luca");

            //preparo una stringa che contiene la query
            //I punti interrogativi sono i valori che saranno conosciuti a runtime dall'applicazione 
            String query = "select * from utente" + " where nome like ?";


            /*
                Una volta ottenuta una connessione,
                si può operare sul DB con query di selezione
                e query di comando (UPDATE, DELETE, INSERT…)
                    -per far questo si ricorre all’interfaccia java.sql.Statement                     
                    -Uno statement viene ottenuto dall’oggetto connessione:
             */
            //I PreparedStatement sono degli Statement quasi completi
            //ai quali dobbiamo passare dei parametri, anche a run-time
            PreparedStatement statement = connessione.prepareStatement(query);

            // Si associano i valori, prevengo l'sql injection
            statement.setString(1, "%" + nome + "%");

            /*
            executeQuery(String) ----> metodo usato per eseguire interrogazioni al DB (SELECT)
            executeUpdate(String)----> metodo usato per inserimenti, aggiornamenti e cancellazioni (INSERT, UPDATE, DELETE).
             */
            //Il metodo executeQuery(String) restituisce un ResultSet , un oggetto-tabella 
            //che rappresenta i dati selezionati dalla nostra interrogazione
            ResultSet result = statement.executeQuery();

            // ciclo sulle righe della tabella restituite
            while (result.next()) {
                Utente utente = new Utente();
                utente.setId(result.getInt("utente_id"));
                utente.setNome(result.getString("nome"));
                utente.setCognome(result.getString("cognome"));
                utente.setPassword(result.getString("password"));
                utente.setEmail(result.getString("email"));
                utente.setUrlFotoProfilo(result.getString("urlFotoProfilo"));
                utente.setDataDiNascita(result.getString("dataDiNascita"));
                utente.setFrasePresentazione(result.getString("frasePresentazione"));

                listaUtentiRegistrati.add(utente);
            }
            //chiudo lo statement, chiudo la connessione e infine ritorno l'utente
            statement.close();
            connessione.close();
            // nel caso la query fallisca
            // viene sollevata una SQLException 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listaUtentiRegistrati;
    }

    /*    
    public void registroUtente(Utente utente) {

        try {
            // path, username, password
            Connection connessione = DriverManager.getConnection(connectionString, "luca", "luca");

            String query = "insert into utente(utente_id, nome, cognome, email, password)"
                    + " values (default, ?, ?, ?, ?)";

            // Prepared Statement
            PreparedStatement statement = connessione.prepareStatement(query);
            // Si associano i valori

            statement.setString(1, utente.getNome());
            statement.setString(2, utente.getCognome());
            statement.setString(3, utente.getEmail());
            statement.setString(4, utente.getPassword());
            // Esecuzione query
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     */
    public void setDatiProfilo(String nome, String cognome, String dataDiNascita, String password, String frasePresentazione, int id) {

        try {
            // path, username, password
            Connection connessione = DriverManager.getConnection(connectionString, "luca", "luca");

            if (frasePresentazione.length() > 0) {
                String query = "update utente"
                        + " set nome = ?, cognome = ?, dataDiNascita = ?, password = ?, frasePresentazione = ?"
                        + " where utente_id = ?";

                // Prepared Statement
                PreparedStatement statement = connessione.prepareStatement(query);
                // Si associano i valori
                statement.setString(1, nome);
                statement.setString(2, cognome);
                statement.setString(3, dataDiNascita);
                statement.setString(4, password);
                statement.setString(5, frasePresentazione);
                statement.setInt(6, id);

                // Esecuzione query
                statement.executeUpdate();
            } else {
                String query = "update utente"
                        + " set nome = ?, cognome = ?, dataDiNascita = ?, password = ?"
                        + " where utente_id = ?";

                // Prepared Statement
                PreparedStatement statement = connessione.prepareStatement(query);
                // Si associano i valori
                statement.setString(1, nome);
                statement.setString(2, cognome);
                statement.setString(3, dataDiNascita);
                statement.setString(4, password);
                statement.setInt(5, id);

                // Esecuzione query
                statement.executeUpdate();

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * **** GESTIONE DB, creo la variabile e i rispettivi metodi *****
     */
    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

}
