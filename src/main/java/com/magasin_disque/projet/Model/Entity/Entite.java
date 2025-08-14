package com.magasin_disque.projet.Model.Entity;

import java.time.*;

public abstract class Entite implements Identifier
{
    // Variable
    /////////////////////////////////////////////////////
    protected static int newId = 1;
    protected int id;
    protected String identifiant; //Mail ou Nom Album
    protected LocalDate dateCreation;

    // Set/Get
    ///////////////////////////////////////////////
    @Override
    public String getIdentifiant()
    {
        return identifiant;
    }
    @Override
    public void setIdentifiant(String _identifiant)
    {
        identifiant = _identifiant;
    }

    public LocalDate getDateCreation()
    {
        return dateCreation;
    }

    public void setDateCreation(LocalDate _dateCreation)
    {
        dateCreation = _dateCreation;
    }
    public int getId()
    {
        return  id;
    }
    public void setId(int _id)
    {
        id = _id;
    }

    //Constructeur
    ///////////////////////////////////////////////////////////////////
    public Entite()
    {
        identifiant = "Default";
        dateCreation = LocalDate.now();
        id = newId++;
    }

    public Entite(String _identifiant, LocalDate _dateCreation)
    {
        identifiant = _identifiant;
        dateCreation = _dateCreation;
        id = newId++;
    }

    public Entite(Entite entite)
    {
        this.id = entite.id;
        this.identifiant = entite.identifiant;
        this.dateCreation = entite.dateCreation;
    }

    // methodes
    /////////////////////////////////////////////
    public int anniversary()
    {
        Period yearDiff =this.dateCreation.until(LocalDate.now());
        return yearDiff.getYears();
    }
    public abstract double calculPromo();

    @Override
    public String toString()
    {
        return "id: " + id + " identifiant: " + identifiant;
    }
}
