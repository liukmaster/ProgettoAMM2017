/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.util.ArrayList;
import java.util.List;

public class GruppoFactory {
    
     private static GruppoFactory singleton;
    
    public static GruppoFactory getIstanza(){
        if(singleton == null){
            singleton = new GruppoFactory();
        }
        return singleton;    
    }
    
    private List<Gruppo> ListaGruppi = new ArrayList<>();
    
    /*
        l'implementazione prevede che la classe singleton abbia
        un unico costruttore privato, in modo da impedire
        l'istanziazione diretta della classe. 
    */
    
    private GruppoFactory(){
        
        UtenteRegistratoFactory utentiregistratifactory = UtenteRegistratoFactory.getInstanza();
        PostFactory postfactory = PostFactory.getIstanza();
        //creo i gruppi
        
        
        Gruppo gruppo1 = new Gruppo();
        gruppo1.setId(0);
        gruppo1.setNomeGruppo("I Benefattori");
        gruppo1.addMembro(utentiregistratifactory.getUtentiRegistratiById(0));
        gruppo1.setPostGruppo(postfactory.getPostById(0));
    
        Gruppo gruppo2 = new Gruppo();
        gruppo2.setId(1);
        gruppo2.setNomeGruppo("I Bellicabelli");
        gruppo2.addMembro(utentiregistratifactory.getUtentiRegistratiById(1));
        gruppo2.setPostGruppo(postfactory.getPostById(1));
        
       
        Gruppo gruppo3 = new Gruppo();
        gruppo3.setId(2);
        gruppo3.setNomeGruppo("I Purificatori");
        gruppo3.addMembro(utentiregistratifactory.getUtentiRegistratiById(2));
        gruppo3.setPostGruppo(postfactory.getPostById(2));
        
        ListaGruppi.add(gruppo1);
        ListaGruppi.add(gruppo2);
        ListaGruppi.add(gruppo3);
    
    }
    
    public Gruppo getGruppoByID(int id){
        for(Gruppo grp : this.ListaGruppi){
            if(grp.getId() == id){
                return grp;
            }
        }
        return null;
    }
    
    public List<Gruppo> getGruppoUtenteList(UtenteRegistrato utente){
        
        List<Gruppo> gruppoUtente = new ArrayList<>();
        
        for(Gruppo grp : this.ListaGruppi){
            if(grp.getMembro().equals(utente)){
                gruppoUtente.add(grp);
            } else {
            }
        }
        return gruppoUtente;
    }
}
    
    
     
    
    
  

