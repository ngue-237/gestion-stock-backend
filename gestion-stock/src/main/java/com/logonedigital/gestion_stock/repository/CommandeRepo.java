package com.logonedigital.gestion_stock.repository;

import com.logonedigital.gestion_stock.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepo extends JpaRepository<Commande, Long> {
    @Query("select c from Commande c where c.etat = true")
    List<Commande> fetchCommandes();
}
