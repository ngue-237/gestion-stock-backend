package com.logonedigital.gestion_stock.services.adresse;

import com.logonedigital.gestion_stock.entities.Adresse;

import java.util.List;

public interface AdresseService {
    Adresse addAdresse(Adresse adresse);
    Adresse updateAdresse(Adresse adresse, Long id);

}
