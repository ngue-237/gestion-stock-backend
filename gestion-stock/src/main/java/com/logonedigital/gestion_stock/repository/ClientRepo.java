package com.logonedigital.gestion_stock.repository;

import com.logonedigital.gestion_stock.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, Long> {
     Optional<Client> findByTelephone(String tel);

     @Query("SELECT c from Client c where c.nom=:nom and c.prenom=:prenom")
     Optional<Client> findByNomAndPrenom(@Param("nom") String nom,@Param("prenom") String prenom);
     @Query("select c from Client c where c.email=:email")
     Optional<Client> findByEmail(@Param("email") String email);




}
