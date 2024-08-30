package com.logonedigital.gestion_stock.services.adresse;

import com.logonedigital.gestion_stock.entities.Adresse;
import com.logonedigital.gestion_stock.exception.ResourceNotFoundException;
import com.logonedigital.gestion_stock.repository.AdresseRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdresseServiceImpl implements AdresseService{

    private final AdresseRepo adresseRepo;

    public AdresseServiceImpl(AdresseRepo adresseRepo) {
        this.adresseRepo = adresseRepo;
    }

    @Override
    public Adresse addAdresse(Adresse adresse) {
        return this.adresseRepo.save(adresse);
    }

    @Override
    public Adresse updateAdresse(Adresse adresse, Long id) {
        Optional<Adresse> oldAdresse = this.adresseRepo.findById(id);
        if (oldAdresse.isEmpty())
            throw new ResourceNotFoundException("Adresse not found !");

        if(!adresse.getRue().equals(oldAdresse.get().getRue()))
            oldAdresse.get().setRue(adresse.getRue());
        if(!adresse.getPays().equals(oldAdresse.get().getPays()))
            oldAdresse.get().setPays(adresse.getPays());
        if(!adresse.getVille().equals(oldAdresse.get().getVille()))
            oldAdresse.get().setVille(adresse.getRue());
        if(!adresse.getCodePostal().equals(oldAdresse.get().getCodePostal()))
            oldAdresse.get().setCodePostal(adresse.getCodePostal());


        return this.adresseRepo.saveAndFlush(oldAdresse.get());
    }
}
