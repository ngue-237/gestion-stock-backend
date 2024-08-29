package com.logonedigital.gestion_stock.services.commande;

import com.logonedigital.gestion_stock.entities.Commande;

import java.util.List;

public interface CommandeService {
    Commande addCommande(Commande commande);
    List<Commande> getAllCommande();
    Commande getCommande(Long id);
    Commande updateCommande(Long id);
    void deleteCommande(Long id);
}
