/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GruppoFactory {

    private static GruppoFactory singleton;

    public static GruppoFactory getIstanza() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }

    /**
     * ** GESTIONE DB, creo la variabile e i rispettivi metodi ***
     */
    private String connectionString;

    public ArrayList<Gruppo> ListaGruppi = new ArrayList<>();

    /*
        l'implementazione prevede che la classe singleton abbia
        un unico costruttore privato, in modo da impedire
        l'istanziazione diretta della classe. 
     */
    private GruppoFactory() {
    }

    public Gruppo getGruppoByID(int id) {

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
            String query = "select * from gruppo" + " where id_gruppo = ?";
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
                Gruppo gruppo = new Gruppo();
                gruppo.setId(result.getInt("id_gruppo"));
                gruppo.setNomeGruppo(result.getString("nome_gruppo"));
                gruppo.setFondatore(UtenteFactory.getInstanza().getUtentiRegistratiById(result.getInt("fondatore")));
                gruppo.setMembri(GruppoFactory.getIstanza().membriGruppo(result.getInt("id_gruppo")));
                
                //chiudo lo statement, chiudo la connessione e infine ritorno l'utente
                statement.close();
                connessione.close();
                return gruppo;
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

    //ritorno il gruppo dell'utente
    public List<Gruppo> getGruppoUtenteList(int id) {

        List<Gruppo> listaGruppi = new ArrayList<>();

        try {
            // path, username, password
            Connection connessione = DriverManager.getConnection(connectionString, "luca", "luca");

            String query = "select * from gruppo_utente" + " join gruppo"
                    + " on gruppo.id_gruppo = gruppo_utente.id_gruppo "
                    + "where gruppo_utente.utente_id = ? ";

            // Prepared Statement
            PreparedStatement statement = connessione.prepareStatement(query);

            // Si associano i valori
            statement.setInt(1, id);

            // Esecuzione query
            ResultSet result = statement.executeQuery();

            // ciclo sulle righe restituite
            while (result.next()) {
                Gruppo gruppo = new Gruppo();
                gruppo.setId(result.getInt("id_gruppo"));
                gruppo.setNomeGruppo(result.getString("nome_gruppo"));
                gruppo.setFondatore(UtenteFactory.getInstanza().getUtentiRegistratiById(result.getInt("fondatore")));
                gruppo.setMembri(GruppoFactory.getIstanza().membriGruppo(result.getInt("id_gruppo")));
                listaGruppi.add(gruppo);
            }
            statement.close();
            connessione.close();
            return listaGruppi;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public List<Gruppo> allGroups() {

        List<Gruppo> listaGruppi = new ArrayList<>();

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
            String query = "select * from gruppo";
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

            //ciclo sulle righe della tabella restituite
            while (result.next()) {
                Gruppo gruppo = new Gruppo();
                gruppo.setId(result.getInt("id_gruppo"));
                gruppo.setNomeGruppo(result.getString("nome_gruppo"));
                gruppo.setFondatore(UtenteFactory.getInstanza().getUtentiRegistratiById(result.getInt("fondatore")));
                gruppo.setMembri(GruppoFactory.getIstanza().membriGruppo(result.getInt("id_gruppo")));

                listaGruppi.add(gruppo);

                //chiudo lo statement, chiudo la connessione e infine ritorno l'utente
            }
            //chiudo lo statement, chiudo la connessione
            statement.close();
            connessione.close();

            return listaGruppi;

            // nel caso la query fallisca
            // viene sollevata una SQLException
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public List<Utente> membriGruppo(int gruppo){
    
    List<Utente> listaMembri = new ArrayList<>();

        try {
            // path, username, password
            Connection connessione = DriverManager.getConnection(connectionString, "luca", "luca");

            String query = "select * from gruppo_utente" + " join utente"
                    + " on utente.utente_id = gruppo_utente.utente_id "
                    + "where gruppo_utente.id_gruppo = ? ";

            // Prepared Statement
            PreparedStatement statement = connessione.prepareStatement(query);

            // Si associano i valori
            statement.setInt(1, gruppo);

            // Esecuzione query
            ResultSet result = statement.executeQuery();

            // ciclo sulle righe restituite
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

                listaMembri.add(utente);
            }
            statement.close();
            connessione.close();
            return listaMembri;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listaMembri;
    }
    /**
     ****** GESTIONE DB, creo la variabile e i rispettivi metodi
     *
     *******
     * @param s
     */
    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

}
