/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;


public class UtenteRegistrato {
    
    private int id;
    private String nome;
    private String cognome;
    private String sesso;
    private String email;
    private String password;
    private String urlFotoProfilo;

    
    /*
        Un utente registrato, ha all'inizio queste caratteristiche di default
    */
    public UtenteRegistrato(){
        this.id = 0;
        this.nome = "";
        this.cognome = "";
        this.sesso = "";
        this.email = "";
        this.password = "";
        
}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }
    
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    /*
        controllo se l'oggetto passato sia diverso da null, se lo e' controllo
        se e' una istanza di UtenteRegistrato e se lo e' controllo che l'id 
        di obj sia uguale a un id di UtenteRegistrato        
    */
    @Override
    public boolean equals(Object obj){
        if(obj != null)
            if(obj instanceof UtenteRegistrato)
                if(this.getId() == ((UtenteRegistrato)obj).getId()) 
                    return true;
        return false;
    }  
    
}

