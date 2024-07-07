package com.an.metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static final Connection CONNECTION ;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            CONNECTION= DriverManager.getConnection("jdbc:mysql://localhost:3306/BANQUE","root","");
            System.out.println("Creation de la connection vers la base de donnée");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  static  Connection getConnection(){
        return CONNECTION;
    }
}
