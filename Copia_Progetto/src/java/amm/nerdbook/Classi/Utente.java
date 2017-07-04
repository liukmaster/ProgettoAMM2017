/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.util.ArrayList;
import java.util.List;

public class Utente {

    private int id;
    public String nome;
    private String cognome;
    private String email;
    private String password;
    private String urlFotoProfilo;
    private String dataDiNascita;
    private String frasePresentazione;

    /*
        Un utente registrato, ha all'inizio queste caratteristiche di default
     */
    public Utente() {
        this.nome = "";
        this.cognome = "";
        this.email = "";
        this.password = "";
        this.dataDiNascita = "";
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

    public String getNomeCognome() {

        return this.nome + " " + this.cognome;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getFrasePresentazione() {
        return frasePresentazione;
    }

    public void setFrasePresentazione(String frasePresentazione) {
        this.frasePresentazione = frasePresentazione;
    }

    /*
        controllo se l'oggetto passato sia diverso da null, se lo e' controllo
        se e' una istanza di Utente e se lo e' controllo che l'id 
        di obj sia uguale a un id di Utente        
     */
    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof Utente) {
                if (this.getId() == ((Utente) obj).getId()) {
                    return true;
                }
            }
        }
        return false;
    }

}
