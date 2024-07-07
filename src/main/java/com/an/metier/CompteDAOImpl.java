package com.an.metier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompteDAOImpl implements CompteDAO {
    @Override
    public void saveCompte(Compte compte) throws SQLException {
        Connection connection=SingletonConnection.getConnection();
        PreparedStatement ps1=connection.prepareStatement("INSERT INTO COMPTES(SOLDE,DATE_CREATION,TYPE) values(?,?,?)");
        ps1.setDouble(1,compte.getSolde());
        ps1.setDate(2,new Date(compte.getDateCreation().getTime()));
        ps1.setString(3,compte.getType().equals(TypeCompte.COURANT)?"COURANT":"EAPRGNE");
        int nombreEnregistrements =ps1.executeUpdate();

    }

    @Override
    public List<Compte> CompteParType(String type) throws SQLException {
        Connection connection=SingletonConnection.getConnection();
        List<Compte> comptes=new ArrayList<>();
        PreparedStatement ps2=connection.prepareStatement("SELECT * FROM COMPTES WHERE TYPE=? ");
        ps2.setString(1,type);
        ResultSet rs2=ps2.executeQuery();
        while(rs2.next())
        {
            Compte compte=new Compte();
            compte.setCode(rs2.getLong("CODE"));
            compte.setSolde(rs2.getDouble("SOLDE"));
            compte.setDateCreation(rs2.getDate("DATE_CREATION"));
            compte.setType(rs2.getString("TYPE").equals("COURANT")?TypeCompte.COURANT:TypeCompte.EPARGNE);
            comptes.add(compte);

        }
        return comptes;
    }

    @Override
    public Compte getCompte(Long code) throws SQLException {
        Connection connection=SingletonConnection.getConnection();
        Compte compte=null;
        PreparedStatement ps2=connection.prepareStatement("SELECT * FROM COMPTES WHERE CODE=? ");
        ps2.setLong(1,code);
        ResultSet rs2=ps2.executeQuery();
        if(rs2.next())
        {
            compte=new Compte();
            compte.setCode(rs2.getLong("CODE"));
            compte.setSolde(rs2.getDouble("SOLDE"));
            compte.setDateCreation(rs2.getDate("DATE_CREATION"));
            compte.setType(rs2.getString("TYPE").equals("COURANT")?TypeCompte.COURANT:TypeCompte.EPARGNE);

        }
        return compte;
    }
}
