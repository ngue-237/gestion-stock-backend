package com.logonedigital.gestion_stock.controler;

import com.logonedigital.gestion_stock.entities.Adresse;
import com.logonedigital.gestion_stock.services.adresse.AdresseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdresseController {

    private final AdresseService adresseService;

    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @PostMapping(path = "/adresse/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Adresse> addAdresse(@RequestBody Adresse adresse){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.adresseService.addAdresse(adresse));
    }

    @PutMapping(path = "/adresse/update_adresse/{id}")
    public ResponseEntity<Adresse> updateAdresse(@RequestBody Adresse adresse, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(this.adresseService.updateAdresse(adresse,id));
    }
}
