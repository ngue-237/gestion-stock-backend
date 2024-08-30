package com.logonedigital.gestion_stock.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String nom;
    private String description;
    private Double prix;
    private Integer quantite;
    private Date dateCreation;
    private Date dateModification;
    private Boolean etat;
    @OneToOne(mappedBy = "produit")
    private Stock stock;
}
