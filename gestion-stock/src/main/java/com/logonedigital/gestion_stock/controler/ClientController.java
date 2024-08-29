package com.logonedigital.gestion_stock.controler;

import com.logonedigital.gestion_stock.dto.clientDto.ClientRequestDTO;
import com.logonedigital.gestion_stock.entities.Client;
import com.logonedigital.gestion_stock.mapper.ClientMapper;
import com.logonedigital.gestion_stock.services.client.ClientServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    private final ClientServiceImpl clientService;
    private final ClientMapper clientMapper;

    public ClientController(ClientServiceImpl clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }



    @Operation(summary = "nous permet d'ajouter un nouveau client", description = "Permet d'ajouter un client dont les informations sont passées dans le corps de la requête et retourne les informations du client ajouté")
    @PostMapping(path = "/client/add")
    @ApiResponses(value={
            @ApiResponse(responseCode = "400", description = "Lorsque un client existe déjà avec l'adresse email qu'un nouveau client veut ajouter"),
            @ApiResponse(responseCode = "201", description = "lorsque le client a été bien ajouté")

    })
    public ResponseEntity<Client> addClient(@Valid @RequestBody ClientRequestDTO clientRequestDTO){
        Client client = this.clientMapper.fromClientRequestDTO(clientRequestDTO);//client.setNom(clientRequestDTO.getNom());
        //client.setPrenom(clientRequestDTO.getPrenom());
        //client.setEmail(clientRequestDTO.getEmail());
        //client.setTelephone(clientRequestDTO.getTelephone());


        return ResponseEntity.status(HttpStatus.CREATED).body(this.clientService.addClient(client));
    }

    @GetMapping(path = "/client/get_all_client")
    public List<Client> getAllClient(){
        return this.clientService.getAllClients();
    }

    @GetMapping(path = "/client/get_client/{id}")
    public Client getClientById(@PathVariable Long id){
        return this.clientService.getClientById(id);
    }
    @GetMapping(path = "/client/get_client_by_telephone/{telephone}")
    public Client getClientByTelephone(@PathVariable String telephone){
        return this.clientService.getClientByTelephone(telephone);
    }
    @GetMapping(path = "/client/get_client_by_nom_prenom/{nom}/{prenom}")
    public Client getClientByNomAndPrenom(@PathVariable String nom,  @PathVariable String prenom){
        return this.clientService.getClientByNomAndPrenom(nom,prenom);
    }

    @DeleteMapping(path = "/client/delete_client_by_id/{id}")
    public String deleteClientById(@PathVariable Long id){
        this.clientService.deleteClientById(id);
        return "Client deleted successfully !";
    }

    @PutMapping(path = "/client/update_client_by_id/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable Long id){
        return this.clientService.updateClient(client,id);
    }
}
