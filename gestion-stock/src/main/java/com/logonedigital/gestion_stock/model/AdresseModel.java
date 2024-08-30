package com.logonedigital.gestion_stock.model;

public record AdresseModel(
        String rue,
        String ville,
        String codePostal,
        String pays
) {
}
