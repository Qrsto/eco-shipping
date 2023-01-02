package it.poliba.is45.ecoshipping.dto;


import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
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

    private String numTelefono;
    private String password;
    private String iban;






}
