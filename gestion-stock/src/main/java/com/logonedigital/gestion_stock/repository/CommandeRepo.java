package com.logonedigital.gestion_stock.repository;

import com.logonedigital.gestion_stock.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepo extends JpaRepository<Commande, Long> {
}
