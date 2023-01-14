package it.poliba.is45.ecoshipping.dto;


import it.poliba.is45.ecoshipping.domain.ERole;
import it.poliba.is45.ecoshipping.domain.Utente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class UtenteDto {

    private long idUtente;
    private String nome;
    private String cognome;
    private Date dataNas;
    private String indirizzoResidenza;
    private String citta;
    private String cap;
    private String username;
    private String iban;
}
