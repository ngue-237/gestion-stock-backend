package com.logonedigital.gestion_stock.services.produit;

import com.logonedigital.gestion_stock.entities.Produit;
import com.logonedigital.gestion_stock.repository.ProduitRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService{
    private final ProduitRepo produitRepo;

    public ProduitServiceImpl(ProduitRepo produitRepo) {
        this.produitRepo = produitRepo;
    }

    @Override
    public Produit addProduit(Produit produit) {
        produit.setDateCreation(new Date());
        produit.setEtat(true);
        return this.produitRepo.save(produit);
    }

    @Override
    public List<Produit> getAllProduit() {
        return this.produitRepo.findAll();
    }

    @Override
    public Produit getProduitById(Long id) {
        return this.produitRepo.findById(id).get();
    }

    @Override
    public Produit updateProduit(Long id, Produit produit) {
        Produit produitToEdit = this.produitRepo.findById(id).get();

        produitToEdit.setNom(produit.getNom());
        produitToEdit.setDescription(produit.getDescription());
        produitToEdit.setPrix(produit.getPrix());
        produitToEdit.setQuantite(produit.getQuantite());
        produitToEdit.setDateModification(new Date());


        return this.produitRepo.saveAndFlush(produitToEdit);
    }

    @Override
    public void deleteProduitById(Long id) {

        this.produitRepo.deleteById(id);
    }
}
