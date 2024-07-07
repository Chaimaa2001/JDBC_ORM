package com.an.metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data @ToString
@AllArgsConstructor @NoArgsConstructor
public class Compte {
    private Long code;
    private double solde;
    private Date dateCreation;
    private TypeCompte type;
}
