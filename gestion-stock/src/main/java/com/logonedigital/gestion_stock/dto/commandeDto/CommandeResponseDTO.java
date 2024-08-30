package com.logonedigital.gestion_stock.dto.commandeDto;

import java.util.Date;

public record CommandeResponseDTO(
         Long idCommande,
         Date dateCommande,
         Boolean etat
         
) {
}
