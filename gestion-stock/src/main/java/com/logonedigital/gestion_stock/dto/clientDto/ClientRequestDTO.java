package com.logonedigital.gestion_stock.dto.clientDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientRequestDTO {
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
    @Length(min = 8, max = 9, message = "Min = 8 et Max = 9" )
    private String telephone;

}
