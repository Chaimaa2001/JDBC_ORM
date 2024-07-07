package com.an.metier;

import java.sql.SQLException;
import java.util.List;

public interface CompteDAO {
    void saveCompte(Compte compte) throws SQLException;
    List<Compte> CompteParType(String type) throws SQLException;
    Compte getCompte(Long code) throws SQLException;

}
