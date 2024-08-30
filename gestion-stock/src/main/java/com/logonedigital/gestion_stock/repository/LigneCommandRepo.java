package com.logonedigital.gestion_stock.repository;

import com.logonedigital.gestion_stock.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandRepo extends JpaRepository<LigneCommande,Long> {
}
