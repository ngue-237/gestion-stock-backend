package com.logonedigital.gestion_stock.services.produit;

import com.logonedigital.gestion_stock.entities.Produit;

import java.util.List;

public interface ProduitService {
    public Produit addProduit(Produit produit);
    public List<Produit> getAllProduit();
    public Produit getProduitById(Long id);
    public Produit updateProduit(Long id, Produit produit);
    public void deleteProduitById(Long id);
}
