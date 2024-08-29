package com.logonedigital.gestion_stock.mapper;

import com.logonedigital.gestion_stock.dto.clientDto.ClientRequestDTO;
import com.logonedigital.gestion_stock.entities.Client;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T17:32:35+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client fromClientRequestDTO(ClientRequestDTO clientRequestDTO) {
        if ( clientRequestDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setNom( clientRequestDTO.getNom() );
        client.setPrenom( clientRequestDTO.getPrenom() );
        client.setEmail( clientRequestDTO.getEmail() );
        client.setTelephone( clientRequestDTO.getTelephone() );

        return client;
    }
}
