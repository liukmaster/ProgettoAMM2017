/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;


/***
    Il singleton è un design pattern creazionale che ha lo scopo di garantire che di
    una determinata classe venga creata una e una sola istanza, e di fornire un punto
    di accesso globale a tale istanza. 
***/

import java.util.ArrayList;
import java.util.List;

public class PostFactory {
    
    private static PostFactory singleton;
    
    public static PostFactory getIstanza(){
        if(singleton == null){
            singleton = new PostFactory();
        }
        return singleton;    
    }
    
    //credo un arrayList di post
    private List<Post> listaPost = new ArrayList<>();
    
    
    /*
        l'implementazione prevede che la classe singleton abbia
        un unico costruttore privato, in modo da impedire
        l'istanziazione diretta della classe. 
    */
    private PostFactory(){
        
        UtenteRegistratoFactory utentiregistratifactory = UtenteRegistratoFactory.getInstanza();
        GruppoFactory gruppofactory = GruppoFactory.getIstanza();
        
        
        //creazione dei Post
        Post post1 = new Post();
        post1.setContenutoPost("ciao sono luca, ho 23 anni e ho una dipendenza per l'alcool");
        post1.setId(0);
        post1.setUtente(utentiregistratifactory.getUtentiRegistratiById(0));
        
        Post post2 = new Post();
        post2.setContenutoPost("ciao sono emanuele e questo sono io da bambino: immagini/piccolo.jpg");
        post2.setId(1);
        post2.setUtente(utentiregistratifactory.getUtentiRegistratiById(1));
        post2.setTipoDiPost(Post.Type.IMAGE);
        
        Post post3 = new Post();
        post3.setContenutoPost("ciao sono fabrizio, ho 24 anni e ho una dipendenza per il computer");
        post3.setId(2);
        post3.setUtente(utentiregistratifactory.getUtentiRegistratiById(2));
        
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
           
    }
    
        /*
            creo un metodo che restituisce un Post tramite l'id
        */
        public Post getPostById(int id){
            for(Post post : this.listaPost){
                if(post.getId() == id){
                    return post;
                }
            }            
            return null;       
        }
        
        
        /*
            creo un metodo che restituisce una lista dei post degli utenti.
            controllo se l'utente passato al metodo e' uguale a uno degli
            utenti dei post, se lo e' inserisco quel post all'interno della lista
            e la restituisco.
        */    

    /**
     *
     * @param utente
     * @return
     */
    
        public List getPostUtenteList(UtenteRegistrato utente){
            
            List<Post> listaPostUtente = new ArrayList<>();
            
            //scorro la lista di post
            for(Post post : this.listaPost){
                    if(post.getUtente().equals(utente)){
                    listaPostUtente.add(post);
                }
            }
            return listaPostUtente;            
        } 
        
        
         
        
                
        
}
