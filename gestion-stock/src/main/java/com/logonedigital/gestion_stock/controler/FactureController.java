package com.logonedigital.gestion_stock.controler;

import com.logonedigital.gestion_stock.dto.facture.FactureRequestDTO;
import com.logonedigital.gestion_stock.entities.Facture;
import com.logonedigital.gestion_stock.services.facture.FactureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FactureController {
    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @PostMapping(path = "/factures/add")
    public ResponseEntity<Facture> addFacture(@RequestBody FactureRequestDTO factureRequestDTO){

        return ResponseEntity
                .status(201)
                .body(this.factureService.addFacture(factureRequestDTO));
    }


    @GetMapping(path = "/factures/get_all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Facture>> getAllFacture(){
        return ResponseEntity
                .status(200)
                .body(this.factureService.getAllFacture());
    }

    @GetMapping(path = "/factures/get_by_id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Facture> getFactureById(@PathVariable Long id){
        return ResponseEntity.status(200)
                .body(this.factureService.getFacture(id));
    }

    @PutMapping(path = "/factures/edit_by_id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Facture> editFacture(@RequestBody FactureRequestDTO factureRequestDTO,@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(this.factureService.updateFacture(factureRequestDTO, id));
    }
}
