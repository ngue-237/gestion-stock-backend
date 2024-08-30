package com.logonedigital.gestion_stock.repository;

import com.logonedigital.gestion_stock.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepo extends JpaRepository<Facture, Long> {
}
