package com.logonedigital.gestion_stock.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Le champ nom ne doit pas être vide")
    @NotBlank(message = "il y a un problème avec le remplissage de ce champ")
    @Length(min = 3, max = 30, message = "le nom doit contenir minimum 3 caractères et maximum 30 caractères")
    private String nom;
    private String prenom;
    @NotEmpty(message = "Le champ email ne doit pas être vide")
    @NotBlank(message = "il y a un problème avec le remplissage de ce champ")
    @Email(message = "votre email n'est pas conforme")
    private String email;
    @NotEmpty(message = "Le champ telephone ne doit pas être vide")
    @NotBlank(message = "il y a un problème avec le remplissage de ce champ")
    private String telephone;
    private Date dateCreation;
    private Date dateModification;
    private Boolean etat;
    @OneToOne
    private Adresse adresse;
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes = new ArrayList<>();



}
