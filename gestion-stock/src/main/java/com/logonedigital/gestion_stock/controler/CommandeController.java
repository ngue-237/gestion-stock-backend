package com.logonedigital.gestion_stock.controler;

import com.logonedigital.gestion_stock.dto.commandeDto.CommandeRequestDTO;
import com.logonedigital.gestion_stock.entities.Client;
import com.logonedigital.gestion_stock.entities.Commande;
import com.logonedigital.gestion_stock.exception.ResourceNotFoundException;
import com.logonedigital.gestion_stock.mapper.CommandeMapper;
import com.logonedigital.gestion_stock.repository.ClientRepo;
import com.logonedigital.gestion_stock.services.commande.CommandeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandeController {

    private final CommandeService commandeService;
    private final CommandeMapper commandeMapper;
    private final ClientRepo clientRepo;

    public CommandeController(CommandeService commandeService, CommandeMapper commandeMapper, ClientRepo clientRepo) {
        this.commandeService = commandeService;
        this.commandeMapper = commandeMapper;
        this.clientRepo = clientRepo;
    }


    @PostMapping(path = "/commandes/add",produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Commande> addCommande(@RequestBody CommandeRequestDTO commandeRequestDTO){

        Commande commande = this.commandeMapper.fromCommandRequestDTO(commandeRequestDTO);
        commande.setClient(this.clientRepo.findById(commandeRequestDTO.clientId()).orElseThrow(()-> new ResourceNotFoundException("client not found !")));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.commandeService.addCommande(commande));
    }
}
