package com.logonedigital.gestion_stock.services.client;

import com.logonedigital.gestion_stock.entities.Client;
import com.logonedigital.gestion_stock.exception.ResourceExistException;
import com.logonedigital.gestion_stock.exception.ResourceNotFoundException;
import com.logonedigital.gestion_stock.repository.ClientRepo;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public Client addClient(Client client) {


        //vérifier que l'adresse email du client n'existe pas dans la BD
        Optional<Client> clientToCheck = this.clientRepo.findByEmail(client.getEmail());
        if (clientToCheck.isPresent())
            throw new ResourceExistException("Cette addresse email a déjà été utilisée");

        client.setEtat(true);
        client.setDateCreation(new Date());

        return this.clientRepo.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return this.clientRepo.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        Optional<Client> client = this.clientRepo.findById(id);
        if(client.isEmpty())
            throw new ResourceNotFoundException("Client with id:"+id+" not found");
        return client.get();
    }

    @Override
    public Client updateClient(Client client, Long id) {
        // 1 -- > Rechercher le client à modifier
        Client clientToEdit = this.clientRepo.findById(id).get();

        // 2 -- > Modifier les anciennes informations du client par les nouvelles informations
        clientToEdit.setNom(client.getNom());
        clientToEdit.setPrenom(client.getPrenom());
        clientToEdit.setTelephone(client.getTelephone());
        clientToEdit.setDateModification(new Date());

        // 3 -- > Sauvegarder les informations du client modifier

      
        return this.clientRepo.saveAndFlush(clientToEdit);
    }

    @Override
    public void deleteClientById(Long id) {
        this.clientRepo.deleteById(id);
    }

    @Override
    public Client getClientByTelephone(String tel) {
        return this.clientRepo.findByTelephone(tel).get();
    }

    @Override
    public Client getClientByNomAndPrenom(String nom, String prenom) {
        return this.clientRepo.findByNomAndPrenom(nom,prenom).get();
    }
}
