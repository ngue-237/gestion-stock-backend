package com.logonedigital.gestion_stock.controler;

import com.logonedigital.gestion_stock.entities.Produit;
import com.logonedigital.gestion_stock.services.produit.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping(path = "/produit/add")
    public Produit addProduit(@RequestBody Produit produit){
        return this.produitService.addProduit(produit);
    }

    @GetMapping(path = "/produit/get_all_produit")
    public List<Produit> getAllProduit(){
        return this.produitService.getAllProduit();
    }

    @GetMapping(path = "/produit/get_produit_by_id/{id}")
    public Produit getProduit(@PathVariable Long id){
        return this.produitService.getProduitById(id);
    }


    @DeleteMapping(path = "produit/delete_produit_by_id/{id}")
    public String deleteProduit(@PathVariable Long id){
        this.produitService.deleteProduitById(id);

        return "Product deleted successfully !";
    }

    @PatchMapping(path = "/produit/update_produit_by_id/{id}")
    public Produit updateProduit(@PathVariable Long id,@RequestBody Produit produit){
        return this.produitService.updateProduit(id, produit);
    }
}
