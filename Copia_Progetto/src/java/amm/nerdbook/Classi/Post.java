/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

public class Post {
    
    //creo una enumerazione in modo tale che i post siano O immagini o Testo
    public enum Type {TEXT, URL};
    private int id;
    private Utente autore;
    private String testoPost;
    private Type tipoDiPost;
    private String immaginePost;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utente getUtente() {
        return autore;
    }

    public void setUtente(Utente utente) {
        this.autore = utente;
    }

    public String getContenutoPost() {
        return testoPost;
    }

    public void setTestoPost(String contenutoPost) {
        this.testoPost = contenutoPost;
    }
    
    public String getImmaginePost(){
        return immaginePost;
    }
    
    public void setImmaginePost(String contenutoPost) {
        this.immaginePost = contenutoPost;
    }

    public Type getTipoDiPost() {
        return tipoDiPost;
    }

    public void setTipoDiPost(Type tipoDiPost) {
        this.tipoDiPost = tipoDiPost;
    }
}
