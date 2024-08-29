package com.logonedigital.gestion_stock.services.commande;

import com.logonedigital.gestion_stock.entities.Commande;
import com.logonedigital.gestion_stock.exception.ResourceNotFoundException;
import com.logonedigital.gestion_stock.repository.CommandeRepo;

import java.util.List;
import java.util.Optional;

public class CommandeServiceImpl implements CommandeService{

    private final CommandeRepo commandeRepo;


    public CommandeServiceImpl(CommandeRepo commandeRepo) {
        this.commandeRepo = commandeRepo;
    }

    @Override
    public Commande addCommande(Commande commande) {
        return this.commandeRepo.save(commande);
    }

    @Override
    public List<Commande> getAllCommande() {
        return this.commandeRepo.findAll();
    }

    @Override
    public Commande getCommande(Long id) {
        Optional<Commande> commande = this.commandeRepo.findById(id);
        if(commande.isEmpty())
            throw new ResourceNotFoundException("commande whith id:"+id+" not found");
        return commande.get();
    }

    @Override
    public Commande updateCommande(Long id) {
        return null;
    }

    @Override
    public void deleteCommande(Long id) {
        Optional<Commande> commande = this.commandeRepo.findById(id);
        if(commande.isEmpty())
            throw new ResourceNotFoundException("commande whith id:"+id+" not found");
        this.commandeRepo.delete(commande.get());
    }
}
