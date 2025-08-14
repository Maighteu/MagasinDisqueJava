package com.magasin_disque.projet.Model.DAL;
import com.magasin_disque.projet.Model.Entity.Album;

import java.util.*;

public class AlbumDAO implements ACDAO{
    private static final AlbumDAO INSTANCE = new AlbumDAO();
    ArrayList<Album> listAlbum = new ArrayList<>();
    Hashtable<String, Album> tableAlbum = new Hashtable<>();
    private AlbumDAO(){}
    public static AlbumDAO getInstance() {
        return INSTANCE;
    }
    public Album rechercheAlbumInListe(Album album)
    {
        if (listAlbum == null) return null;
        for (int i=0; i<listAlbum.size();i++)
        {
            if (listAlbum.get(i).equals(album))
            {
                return listAlbum.get(i);
            }
        }
        return null;
    }
    public Album rechercheAlbumInHashtable(Album album){
        Album a;
         a = tableAlbum.get(album.getIdentifiant().toLowerCase());
         if (album.equals(a))
            return a;
         return null;
    }
    public boolean addAlbumInStock(Album album)
    {
        Album a;
        if ((a = rechercheAlbumInHashtable(album)) != null)
        {
            a.setQuantite( a.getQuantite()+ album.getQuantite());
            return true;
        }
        else {
            listAlbum.add(album);
            tableAlbum.put(album.getIdentifiant().toLowerCase(),album);
            return true;
        }
    }
    public boolean removeAlbumInStock(Album _album)
    {
        Album album;
        if (( album = rechercheAlbumInHashtable(_album)) == null)
            return false;
        else {
            if (album.getQuantite()>0)
            {
                album.setQuantite(album.getQuantite()-_album.getQuantite());
                return true;
            }
            else {
                listAlbum.remove(album);
                tableAlbum.remove(album.getIdentifiant().toLowerCase(), album);
                return true;
            }
        }
    }
    public boolean updateAlbumInStock(Album _album)
    {
        Album a;
        if ((a = rechercheAlbumInListe(_album))!=null) {
            a = _album;
            return true;
        }
        return false;
    }
    public boolean SynchroListHashTable()
    {
        if (listAlbum == null) return false;
        for (Album i: listAlbum)
        {
            if (rechercheAlbumInHashtable(i) == null)
                tableAlbum.put(i.getIdentifiant().toLowerCase(),i);
        }
        return true;
    }
}
