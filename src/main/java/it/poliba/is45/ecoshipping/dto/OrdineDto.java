package it.poliba.is45.ecoshipping.dto;


import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.enumeratives.FasciaOraria;
import it.poliba.is45.ecoshipping.enumeratives.MetodoPagamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrdineDto {

    private int idOrdine;
    private int idSpedizione;
    private String indirizzoPartenza;
    private String indirizzoConsegna;
    private float volumeSpedizione;
    private float pesoSpedizione;
    private String numTelefonoDestinatario;
    private MetodoPagamento metodoPagamento;
    private FasciaOraria fasciaOraria;
    private String noteConsegna;
    private float costoFinale;
    private Double longitudinePartenza;
    private Double latitudinePartenza;
    private Double longitudineDestinazione;
    private Double latitudineDestinazione;
    private Utente id_utente;
}
