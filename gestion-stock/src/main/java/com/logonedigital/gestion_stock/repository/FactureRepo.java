package com.logonedigital.gestion_stock.repository;

import com.logonedigital.gestion_stock.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepo extends JpaRepository<Facture, Long> {
}
