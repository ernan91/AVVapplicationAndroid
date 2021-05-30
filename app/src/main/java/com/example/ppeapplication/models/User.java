package com.example.ppeapplication.models;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String password;
    private String nom_compte;
    private String email;
    private String date_inscription;
    private String date_ferme;
    public String roles;
    private String date_deb_sejour;
    private String date_fin_sejour;
    private String date_naiss_compte;
    private String username;
    private String num_tel_compte;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom_compte() {
        return nom_compte;
    }

    public void setNom_compte(String nom_compte) {
        this.nom_compte = nom_compte;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(String date_inscription) {
        this.date_inscription = date_inscription;
    }

    public Object getDate_ferme() {
        return date_ferme;
    }

    public void setDate_ferme(String date_ferme) {
        this.date_ferme = date_ferme;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getDate_deb_sejour() {
        return date_deb_sejour;
    }

    public void setDate_deb_sejour(String date_deb_sejour) {
        this.date_deb_sejour = date_deb_sejour;
    }

    public String getDate_fin_sejour() {
        return date_fin_sejour;
    }

    public void setDate_fin_sejour(String date_fin_sejour) {
        this.date_fin_sejour = date_fin_sejour;
    }

    public String getDate_naiss_compte() {
        return date_naiss_compte;
    }

    public void setDate_naiss_compte(String date_naiss_compte) {
        this.date_naiss_compte = date_naiss_compte;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNum_tel_compte() {
        return num_tel_compte;
    }

    public void setNum_tel_compte(String num_tel_compte) {
        this.num_tel_compte = num_tel_compte;
    }


}

