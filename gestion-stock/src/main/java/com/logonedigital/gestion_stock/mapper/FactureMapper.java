package com.logonedigital.gestion_stock.mapper;

import com.logonedigital.gestion_stock.dto.facture.FactureRequestDTO;
import com.logonedigital.gestion_stock.entities.Facture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FactureMapper {
    Facture fromFactureRequestDTO(FactureRequestDTO factureRequestDTO);
}
