package com.example.ppeapplication.models;

import java.io.Serializable;

public class Activite implements Serializable {
    private String id;
    private String heure_rdv;
    private  String heure_debut_activite;
    private String date_fin_activite;
    private String prix_activite;
    private String nom_responsable;
    private  String prenom_responsable;
    private String id_type_activite_id;
    private String nom_activite;
    private String animation_id;
    private String image;
    private String description_activite;

    public  String getId() {return id;}
    public void setId() {this.id = id;}
    public String getHeure_rdv() {return heure_rdv;}
    public void setHeure_rdv() {this.heure_rdv = heure_rdv;}
    public String getHeure_debut_activite() {return heure_debut_activite;}
    public void setHeure_debut_activite () { this.heure_debut_activite = heure_debut_activite;}
    public String getDate_fin_activite () {return date_fin_activite;}
    public void setDate_fin_activite () {this.date_fin_activite = date_fin_activite;}
    public  String getPrix_activite () {return prix_activite;}
    public void setPrix_activite () {this.prix_activite = prix_activite;}
    public String getNom_responsable() {return nom_responsable;}
    public void setNom_responsable () {this.nom_responsable = nom_responsable;}
    public String getPrenom_responsable() {return prenom_responsable;}
    public void setPrenom_responsable() {this.prenom_responsable = prenom_responsable;}
    public String getId_type_activite_id() {return id_type_activite_id;}
    public void setId_type_activite_id() {this.id_type_activite_id = id_type_activite_id;}

    public String getNom_activite() {
        return nom_activite;
    }

    public void setNom_activite(String nom_activite) {
        this.nom_activite = nom_activite;
    }

    public String getAnimation_id() {
        return animation_id;
    }

    public void setAnimation_id(String animation_id) {
        this.animation_id = animation_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription_activite() {
        return description_activite;
    }

    public void setDescription_activite(String description_activite) {
        this.description_activite = description_activite;
    }
}
