package it.poliba.is45.ecoshipping.dto;


import it.poliba.is45.ecoshipping.domain.Role;
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
    private int idUtente;
    private String nome;
    private String cognome;
    private Date dataNas;
    private String indirizzoResidenza;  //applicarlo a tutte lentita
    private String citta;
    private String cap;
    private String mobile;
    private String password;
    private String username;
    private Role role;
    private String iban;






}
