package com.an.test;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/BANQUE","root","");
        PreparedStatement ps1=conn.prepareStatement("INSERT INTO COMPTES(SOLDE,DATE_CREATION,TYPE) values(?,?,?)");
        ps1.setDouble(1,Math.random()*90000);
        ps1.setDate(2,new Date(new java.util.Date().getTime()));
        ps1.setString(3,"EPARGNE");
        int nombreEnregistrements =ps1.executeUpdate();
        System.out.println("Enregistrement de "+nombreEnregistrements+ " Effectué");


        PreparedStatement ps2=conn.prepareStatement("SELECT * FROM COMPTES WHERE TYPE=? ");
        ps2.setString(1,"EPARGNE");
        ResultSet rs2=ps2.executeQuery();
        ResultSetMetaData resultSetMetaData=rs2.getMetaData();
        for(int i=1;i<=resultSetMetaData.getColumnCount();i++)
        {
            System.out.print(resultSetMetaData.getColumnName(i)+"\t");
        }
        System.out.println();
        System.out.println("--------------------------------");

        while(rs2.next())
        {
            for(int i=1;i<=resultSetMetaData.getColumnCount();i++)
            {
                System.out.print(rs2.getString(i)+"\t");
            }
            System.out.println("----------------------------------");
        }
       /* while(rs2.next())
        {
            System.out.println(rs2.getLong("CODE")+"\t");
            System.out.println(rs2.getString("SOLDE")+"\t");
            System.out.println(rs2.getDate("DATE_CREATION")+"\t");
            System.out.println(rs2.getString("TYPE")+"\t");
            System.out.println(
            );
            System.out.println("------------------------------");
        }*/

    }
}
