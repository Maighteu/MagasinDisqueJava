package com.magasin_disque.projet.Model.DAL;


import com.magasin_disque.projet.Model.Entity.Album;
import com.magasin_disque.projet.View.FactureTable;

import java.util.ArrayList;
import java.util.Hashtable;

public final class FactureDAO {
    private static final FactureDAO INSTANCE = new FactureDAO();
    ArrayList<Album> facture = new ArrayList<>();
    private FactureDAO(){}
    public static FactureDAO getInstance(){
        return INSTANCE;
    }
    public Album rechercheAlbumInFacture(Album album)
    {
        if (facture == null) return null;
        for (int i=0; i<facture.size();i++)
        {
            if (facture.get(i).equals(album))
            {
                return facture.get(i);
            }
        }
        return null;
    }
    public boolean addAlbumInFacture(Album album)
    {
        Album a;
        if ((a = rechercheAlbumInFacture(album)) != null)
        {
            a.setQuantite( a.getQuantite()+ album.getQuantite());
            return true;
        }
        else {
            Album copieAlbum = album.clone();
            copieAlbum.setQuantite(1);
            facture.add(copieAlbum);
            return true;
        }
    }
    public boolean removeAlbumInFacture(Album _album)
    {
        Album album;
        if (( album = rechercheAlbumInFacture(_album)) == null)
            return false;
        else {
            if (album.getQuantite()>0)
            {
                album.setQuantite(album.getQuantite()-_album.getQuantite());
                return true;
            }
            else {
                facture.remove(album);
                return true;
            }
        }
    }
    public boolean updateAlbumInFacture(Album _album)
    {
        Album a;
        if ((a = rechercheAlbumInFacture(_album))!=null) {
            a = _album;
            return true;
        }
        return false;
    }

    public ArrayList<Album> getList()
    {
        ArrayList<Album> copy = new ArrayList<>();
        for (Album a : facture)
        {
            copy.add(a.clone()); //clone de clone modifié?
        }
        return copy;
    }
}
