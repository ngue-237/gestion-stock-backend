package com.logonedigital.gestion_stock.services.facture;

import com.logonedigital.gestion_stock.dto.facture.FactureRequestDTO;
import com.logonedigital.gestion_stock.entities.Facture;

import java.util.List;

public interface FactureService {

    Facture addFacture(FactureRequestDTO factureRequestDTO);
    List<Facture> getAllFacture();
    Facture getFacture(Long id);
    Facture updateFacture(FactureRequestDTO factureRequestDTO, Long id);
}
