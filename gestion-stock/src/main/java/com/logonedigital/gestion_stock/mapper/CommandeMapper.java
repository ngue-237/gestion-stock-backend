package com.logonedigital.gestion_stock.mapper;

import com.logonedigital.gestion_stock.dto.commandeDto.CommandeRequestDTO;
import com.logonedigital.gestion_stock.dto.commandeDto.CommandeResponseDTO;
import com.logonedigital.gestion_stock.entities.Commande;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    Commande fromCommandRequestDTO(CommandeRequestDTO commandeRequestDTO);
    CommandeResponseDTO fromCommande(Commande commande);
}
