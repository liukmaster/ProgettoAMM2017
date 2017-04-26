/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

public class Post {
    
    //creo una enumerazione in modo tale che i post siano O immagini o Testo
    public enum Type {TEXT, IMAGE};
    private int id;
    private UtenteRegistrato utente;
    private String contenutoPost;
    private Type tipoDiPost;
    
    public Post(){
        this.id = 0;
        this.contenutoPost = "";
        this.tipoDiPost = Type.TEXT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UtenteRegistrato getUtente() {
        return utente;
    }

    public void setUtente(UtenteRegistrato utente) {
        this.utente = utente;
    }

    public String getContenutoPost() {
        return contenutoPost;
    }

    public void setContenutoPost(String contenutoPost) {
        this.contenutoPost = contenutoPost;
    }

    public Type getTipoDiPost() {
        return tipoDiPost;
    }

    public void setTipoDiPost(Type tipoDiPost) {
        this.tipoDiPost = tipoDiPost;
    }
}
