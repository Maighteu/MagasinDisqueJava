package com.magasin_disque.projet.Model.Entity;

public class User implements Identifier {
    // Variable
    /////////////////////////////////
    private int hashPassword;
    private String identifiant;

    // Set/Get
    @Override
    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public void setIdentifiant(String _identifiant) {
        identifiant = _identifiant;
    }
    public User()
    {
        identifiant = "default";
        hashPassword = -1;
    }
    public User(String _identidiant, String _password)
    {
        identifiant = _identidiant;
        hashPassword = PasswordToHash(_password);
    }
    public int getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(int hashPassword) {
        this.hashPassword = hashPassword;
    }

    public int PasswordToHash(String _password)
    {
        int Hash = 0;

        return Hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return identifiant.equals(user.identifiant);
    }
    @Override
    public String toString()
    {
        return "Vous avez été servi par: " + identifiant;
    }
}

