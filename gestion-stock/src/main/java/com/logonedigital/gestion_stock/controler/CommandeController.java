package com.logonedigital.gestion_stock.controler;

import com.logonedigital.gestion_stock.dto.commandeDto.CommandeRequestDTO;
import com.logonedigital.gestion_stock.dto.commandeDto.CommandeResponseDTO;
import com.logonedigital.gestion_stock.entities.Commande;
import com.logonedigital.gestion_stock.exception.ResourceNotFoundException;
import com.logonedigital.gestion_stock.mapper.CommandeMapper;
import com.logonedigital.gestion_stock.repository.ClientRepo;
import com.logonedigital.gestion_stock.services.commande.CommandeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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



        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.commandeService.addCommande(commandeRequestDTO));
    }

    @GetMapping(path = "/commandes/get_by_id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Commande> getCommande(@PathVariable Long id){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.commandeService.getCommande(id));
    }

    @GetMapping(path = "/commandes/get_all_commande", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Commande>>getAllCommande(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.commandeService.getAllCommande());
    }

    @PutMapping(path = "/commandes/change_commande_status/{id}")
    public ResponseEntity<Commande> changeCommandeStatus(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(this.commandeService.toggleCommandeStatus(id));
    }
}
