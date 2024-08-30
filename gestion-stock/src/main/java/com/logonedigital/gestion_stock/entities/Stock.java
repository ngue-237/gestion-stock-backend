package com.logonedigital.gestion_stock.entities;

import jakarta.persistence.*;

@Entity
public class Stock {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;
    private Integer quantiteEnStock;
    @OneToOne
    private Produit produit;
}
