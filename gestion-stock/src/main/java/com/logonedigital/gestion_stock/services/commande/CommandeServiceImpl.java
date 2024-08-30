package com.logonedigital.gestion_stock.services.commande;

import com.logonedigital.gestion_stock.dto.commandeDto.CommandeRequestDTO;
import com.logonedigital.gestion_stock.dto.commandeDto.CommandeResponseDTO;
import com.logonedigital.gestion_stock.entities.Commande;
import com.logonedigital.gestion_stock.exception.ResourceNotFoundException;
import com.logonedigital.gestion_stock.mapper.CommandeMapper;
import com.logonedigital.gestion_stock.repository.ClientRepo;
import com.logonedigital.gestion_stock.repository.CommandeRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService{

    private final CommandeRepo commandeRepo;
    private final CommandeMapper commandeMapper;
    private final ClientRepo clientRepo;


    public CommandeServiceImpl(CommandeRepo commandeRepo, CommandeMapper commandeMapper, ClientRepo clientRepo) {
        this.commandeRepo = commandeRepo;
        this.commandeMapper = commandeMapper;
        this.clientRepo = clientRepo;
    }

    @Override
    public Commande addCommande(CommandeRequestDTO commandeRequestDTO) {
        Commande commande = this.commandeMapper.fromCommandRequestDTO(commandeRequestDTO);
        commande.setClient(this.clientRepo.findById(commandeRequestDTO.clientId()).orElseThrow(()-> new ResourceNotFoundException("client not found !")));
        commande.setDateCommande(new Date());
        commande.setEtat(true);
        return this.commandeRepo.save(commande);
    }
/*
    @Override
    public List<CommandeResponseDTO> getAllCommande() {
        return this.commandeRepo.findAll()
                .stream().map(commande -> this.commandeMapper.fromCommande(commande))
                .toList();
    }
*/
    @Override
    public List<Commande> getAllCommande() {
        return this.commandeRepo.fetchCommandes();
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

    @Override
    public Commande disableCommande(Long id) {
        Optional<Commande> commande = this.commandeRepo.findById(id);
        if(commande.isEmpty())
            throw new ResourceNotFoundException("commande whith id:"+id+" not found");
        commande.get().setEtat(false);

        return this.commandeRepo.saveAndFlush(commande.get());
    }
}
