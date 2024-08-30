package com.logonedigital.gestion_stock.services.commande;

import com.logonedigital.gestion_stock.dto.commandeDto.CommandeRequestDTO;
import com.logonedigital.gestion_stock.dto.commandeDto.CommandeResponseDTO;
import com.logonedigital.gestion_stock.entities.Commande;

import java.util.List;

public interface CommandeService {
    Commande addCommande(CommandeRequestDTO commandeRequestDTO);
    List<Commande> getAllCommande();
    Commande getCommande(Long id);
    Commande updateCommande(Long id);
    void deleteCommande(Long id);
    Commande toggleCommandeStatus(Long id);
}
