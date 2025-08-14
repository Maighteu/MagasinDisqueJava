package com.magasin_disque.projet.Model.Entity;

import java.time.LocalDate;

public class Client extends Entite
{
    // Properties
    ///////////////////////////////////////
    private String nom;
    private String prenom;

    // Set/Get
    ////////////////////////////////////////
    public String getNom()
    {
        return nom;
    }
    public void setNom(String _nom)
    {
        nom = _nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String _prenom){
        prenom = _prenom;
    }

    public Client()
    {
        super();
        nom = "defaultNom";
        prenom= "defaultPrenom";
    }
    public Client(String _identifiant, LocalDate _dateCreation, String _nom, String _prenom)
    {
        super(_identifiant, _dateCreation);
        nom = _nom;
        prenom = _prenom;
    }

    // Methode
    /////////////////////////////////
    @Override
    public double calculPromo()
    {
        int year = this.anniversary();
        if (year < 5)
            return 0;
        else if (year < 10)
            return 2;
        else if (year < 15)
            return 5;
        else return 10;

    }
    @Override
    public String toString()
    {
        return super.toString() +" Nom: " + nom + " Prenom: " + prenom;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return identifiant.equals(client.identifiant);
    }

}
