package it.poliba.is45.ecoshipping.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class UtenteDto {
    private long idUtente;
    private String nome;
    private String cognome;
    private String indirizzoResidenza;  //applicarlo a tutte lentita
    private String citta;
    private String cap;
    private String dataNas;
    private String numTelefono;




}
