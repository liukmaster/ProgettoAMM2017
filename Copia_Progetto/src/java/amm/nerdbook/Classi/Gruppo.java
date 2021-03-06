/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;
        
import java.util.ArrayList;
import java.util.List;

public class Gruppo {
    private int id;
    private String nomeGruppo;
    private List<Utente> membri;
    private List<Post> postGruppo;
    private Utente fondatore;
 
    public Gruppo(){
        this.id = 0;
        this.nomeGruppo = "";
        membri = new ArrayList<>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeGruppo() {
        return nomeGruppo;
    }

    public void setNomeGruppo(String nomeGruppo) {
        this.nomeGruppo = nomeGruppo;
    }
    
    public void addMembro(Utente nuovoMembro){
       membri.add(nuovoMembro);
    }
    
    public List<Utente> getMembri(){
        return membri;
    }
    
    public void setMembri(List<Utente> nuovi){
        membri = nuovi;
    }
    
    public void setPostGruppo(Post nuovoPost){
        postGruppo.add(nuovoPost);
    }
    
    public List getPostGruppo(){
        return postGruppo;
    }
    
    public Utente getFondatore() {
        return fondatore;
    }

    public void setFondatore(Utente fondatore) {
        this.fondatore = fondatore;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj != null)
            if(obj instanceof Gruppo)
                if(this.getId() == ((Gruppo)obj).getId()) 
                    return true;
        return false;
    }
}
