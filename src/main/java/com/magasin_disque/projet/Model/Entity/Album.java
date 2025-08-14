package com.magasin_disque.projet.Model.Entity;

import java.time.LocalDate;
public class Album extends Entite
{
    private TypeAlbum typeAlbum;
    private String imageName;
    private double prixAlbum;
    private String band;
    private int quantite;

    public void setBand(String band) {
        this.band = band;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setPrixAlbum(double prixAlbum) {
        this.prixAlbum = prixAlbum;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setTypeAlbum(TypeAlbum typeAlbum) {
        this.typeAlbum = typeAlbum;
    }

    public double getPrixAlbum() {
        return prixAlbum;
    }

    public TypeAlbum getTypeAlbum() {
        return typeAlbum;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getBand() {
        return band;
    }

    public String getImageName() {
        return imageName;
    }

    //constructeur
    //////////////////////////////////////////////////////////////////
    public Album()
    {
        super();
        prixAlbum = 0;
        typeAlbum = TypeAlbum.Disque;
        quantite = 0;
        band ="defaultBand";
        imageName = null;
    }
    public Album(String _identifiant, LocalDate _dateCreation,int _prixAlbum, TypeAlbum _typeAlbum, int _quantite,String _band,String _imageName) {
        super(_identifiant, _dateCreation);
        prixAlbum = _prixAlbum;
        typeAlbum = _typeAlbum;
        quantite = _quantite;
        band = _band;
        imageName = _imageName;
    }

    //Modele
    ///////////////////////////////////////////////////////
    @Override
    public double calculPromo(){
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
        return super.toString() +" " + typeAlbum + " Band: " + band + " Prix unitaire: "+prixAlbum+ " Quantite: " + quantite;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Album album = (Album) obj;
        return id == album.id && band.equals(album.band) && dateCreation.equals(album.dateCreation);
    }
    @Override
    public Album clone(){
        Album copy = new Album();
        copy.id = this.id;
        copy.identifiant = this.identifiant;
        copy.dateCreation = this.dateCreation;
        copy.prixAlbum = this.prixAlbum;
        copy.imageName = this.imageName;
        copy.band = this.band;
        return copy;
    }
}
