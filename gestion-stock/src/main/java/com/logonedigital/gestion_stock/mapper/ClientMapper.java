package com.logonedigital.gestion_stock.mapper;

import com.logonedigital.gestion_stock.dto.clientDto.ClientRequestDTO;
import com.logonedigital.gestion_stock.entities.Client;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")

public interface ClientMapper {
    Client fromClientRequestDTO(ClientRequestDTO clientRequestDTO);
}
