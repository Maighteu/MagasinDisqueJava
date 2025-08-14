package com.magasin_disque.projet.Model.DAL;

import com.magasin_disque.projet.Model.Entity.Album;
import com.magasin_disque.projet.Model.Entity.Client;

import java.util.*;

public final class ClientDAO implements ACDAO{
    private static final ClientDAO INSTANCE = new ClientDAO();
    ArrayList<Client> listClient = new ArrayList<>();
    Hashtable<String, Client> tableClient = new Hashtable<>();
   private ClientDAO(){}
    public static ClientDAO getInstance()
    {
        return INSTANCE;
    }
    public Client rechercheClientInListe(Client client)
    {
        if (listClient == null) return null;
        for (Client i: listClient)
        {
            if (i.equals(client))
            {
                return i;
            }
        }
        return null;
    }
    public Client rechercheClientInHashtable(Client client){
           return tableClient.get(client.getIdentifiant().toLowerCase());
    }
    public boolean addClient(Client client)
    {
        if (rechercheClientInHashtable(client) != null)
            return false;
        else {
            listClient.add(client);
            tableClient.put(client.getIdentifiant().toLowerCase(),client);
            return true;
        }
    }
    public boolean removeClient(Client _client)
    {
        Client client;
        if (( client = rechercheClientInHashtable(_client)) == null)
            return false;
        else {
            listClient.remove(client);
            tableClient.remove(client.getIdentifiant().toLowerCase(),client);
            return true;
        }
    }

    public boolean updateClientInListe(Client _client)
    {
        Client a;
        if ((a = rechercheClientInListe(_client))!=null) {
            a = _client;
            return true;
        }
        return false;
    }

    public boolean SynchroListHashTable()
    {
        if (listClient == null) return false;
        for (Client i: listClient)
        {
            if (rechercheClientInHashtable(i) == null)
                tableClient.put(i.getIdentifiant().toLowerCase(),i);
        }
        return true;
    }
}
