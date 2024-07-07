package com.an.test;

import com.an.metier.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Test2 {
    public static void main(String[] args) throws SQLException {
        CompteDAO dao=new CompteDAOImpl();
        dao.saveCompte(new Compte(null,6000,new Date(), TypeCompte.EPARGNE));
        dao.saveCompte(new Compte(null,6000,new Date(), TypeCompte.COURANT));

        System.out.println("Liste des comptes courants:");
        List<Compte> comptesList=dao.CompteParType("Courant");
        comptesList.forEach(cp->{
            System.out.println(cp.toString());
        });
        System.out.println("Consultation d'un compte:");
        System.out.println("-----------------");
        Compte compte=dao.getCompte(2L);
        System.out.println(compte);

    }
}
