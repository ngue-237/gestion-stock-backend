package com.logonedigital.gestion_stock.repository;

import com.logonedigital.gestion_stock.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepo extends JpaRepository<Produit, Long> {
}
