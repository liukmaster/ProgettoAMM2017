/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/***
    Il singleton è un design pattern creazionale che ha lo scopo di garantire che di
    una determinata classe venga creata una e una sola istanza, e di fornire un punto
    di accesso globale a tale istanza. 
***/

package amm.nerdbook.Classi;

import java.util.ArrayList;
import java.util.List;
        
public class UtenteFactory {
    
    private static UtenteFactory singleton;
    
    public static UtenteFactory getInstanza(){
        if(singleton == null){
            singleton = new UtenteFactory();
        }
        return singleton;               
    }
    
    //creo un arraylist di utentiRegistrati
    public ArrayList<Utente> listaUtentiRegistrati = new ArrayList<>();
    
    
    
    /*
        l'implementazione prevede che la classe singleton abbia
        un unico costruttore privato, in modo da impedire
        l'istanziazione diretta della classe. 
    */
    private UtenteFactory(){
        //creo utenti registrati
        
        Utente utente1 = new Utente();
        utente1.setId(0);
        utente1.setNome("Luca");
        utente1.setCognome("Fadda");
        utente1.setSesso("maschio");
        utente1.setEmail("luca@hotmail.it");
        utente1.setPassword("123");
        utente1.setUrlFotoProfilo("/immagini/lucaprofilo.jpg");
               
        Utente utente2 = new Utente();
        utente2.setId(1);
        utente2.setNome("Emanuel");
        utente2.setCognome("Fois");
        utente2.setSesso("maschio");
        utente2.setEmail("emanuel@hotmail.it");
        utente2.setPassword("123");
        utente2.setUrlFotoProfilo("/immagini/emanuelprofilo.jpg");
    
        Utente utente3 = new Utente();
        utente3.setId(2);
        utente3.setNome("Fabrizio");
        utente3.setCognome("Basciu");
        utente3.setSesso("maschio");
        utente3.setEmail("fabrizio@hotmail.it");
        utente3.setPassword("123");
        utente3.setUrlFotoProfilo("/immagini/fabrizioprofilo.jpg");
        
        
        //aggiungo alla lista Utente gli utenti creati
        listaUtentiRegistrati.add(utente1);
        listaUtentiRegistrati.add(utente2);
        listaUtentiRegistrati.add(utente3);
        

        
    }
    
    /*
        scorro la lista degli utenti registrati e restituisco l'utente 
         se l'id inserito tramite il metodo e' uguale a uno degli id degli utenti 
        presenti, allora restituisco l'utente
    */
    public Utente getUtentiRegistratiById(int id){
        
        for(Utente utente : this.listaUtentiRegistrati){
            if(utente.getId() == id){
                return utente;
            }
        }
    return null;     
  
    }
    
    public List<Utente> getUtentiRegistrati(){
        return listaUtentiRegistrati;
    
    }  
}
