package com.logonedigital.gestion_stock.services.facture;

import com.logonedigital.gestion_stock.dto.facture.FactureRequestDTO;
import com.logonedigital.gestion_stock.entities.Commande;
import com.logonedigital.gestion_stock.entities.Facture;
import com.logonedigital.gestion_stock.exception.ResourceNotFoundException;
import com.logonedigital.gestion_stock.mapper.FactureMapper;
import com.logonedigital.gestion_stock.repository.CommandeRepo;
import com.logonedigital.gestion_stock.repository.FactureRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FactureServiceImpl implements FactureService{
   private final FactureRepo factureRepo;
   private final FactureMapper factureMapper;
   private final CommandeRepo commandeRepo;

    public FactureServiceImpl(FactureRepo factureRepo, FactureMapper factureMapper, CommandeRepo commandeRepo) {
        this.factureRepo = factureRepo;
        this.factureMapper = factureMapper;
        this.commandeRepo = commandeRepo;
    }

    @Override
    public Facture addFacture(FactureRequestDTO factureRequestDTO) {
        Optional<Commande> commande = this.commandeRepo.findById(factureRequestDTO.idCommande());

        if(commande.isEmpty())
            throw new ResourceNotFoundException("Commande not found !");

        Facture facture = this.factureMapper.fromFactureRequestDTO(factureRequestDTO);
        facture.setCommande(commande.get());
        facture.setDateCreation(new Date());
        facture.setEtat(true);
        return this.factureRepo.save(facture);
    }

    @Override
    public List<Facture> getAllFacture() {
        return this.factureRepo.findAll();
    }

    @Override
    public Facture getFacture(Long id) {


        return this.factureRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Facture not found !"));
    }

    @Override
    public Facture updateFacture(FactureRequestDTO factureRequestDTO, Long id) {
        Facture factureToEdit = this.factureRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Facture not found !"));

        if (!Objects.equals(factureToEdit.getMontant(), factureRequestDTO.montant()))
            factureToEdit.setMontant(factureRequestDTO.montant());

        Commande currentCommande = factureToEdit.getCommande();
        if (currentCommande == null || !Objects.equals(currentCommande.getIdCommande(), factureRequestDTO.idCommande())) {
            Commande newCommande = this.commandeRepo.findById(factureRequestDTO.idCommande())
                    .orElseThrow(() -> new ResourceNotFoundException("Commande not found!"));

            factureToEdit.setCommande(newCommande);
        }


        factureToEdit.setDateModification(new Date());


        return this.factureRepo.saveAndFlush(factureToEdit);
    }
}
