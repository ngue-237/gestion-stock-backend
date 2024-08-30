package com.logonedigital.gestion_stock.repository;

import com.logonedigital.gestion_stock.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock,Long> {
}
