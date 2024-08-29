package com.logonedigital.gestion_stock.services.client;

import com.logonedigital.gestion_stock.entities.Client;

import java.util.List;

public interface ClientService {
    public Client addClient(Client client);
    public List<Client> getAllClients();
    public Client getClientById(Long id);
    public Client updateClient(Client client, Long id);
    public void deleteClientById(Long id);
    public Client getClientByTelephone(String tel);
    public Client getClientByNomAndPrenom(String nom, String prenom);

}
