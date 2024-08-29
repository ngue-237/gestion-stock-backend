package com.logonedigital.gestion_stock.entities;

import jakarta.persistence.*;

@Entity
public class Stock {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantiteEnStock;
    @OneToOne
    private Produit produit;
}
