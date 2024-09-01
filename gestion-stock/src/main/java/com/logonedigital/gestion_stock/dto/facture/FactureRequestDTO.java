package com.logonedigital.gestion_stock.dto.facture;

public record FactureRequestDTO(
        Double montant,
        Long idCommande
) {
}
