package com.logonedigital.gestion_stock.dto.clientDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientRequestDTO {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;

}
