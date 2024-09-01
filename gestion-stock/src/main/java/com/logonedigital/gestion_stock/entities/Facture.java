package com.logonedigital.gestion_stock.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Facture implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private Double montant;
    private Date dateCreation;
    private Date dateModification;
    private Boolean etat;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "facture")
    private Commande commande;
}
