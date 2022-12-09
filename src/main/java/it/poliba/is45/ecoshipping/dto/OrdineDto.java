package it.poliba.is45.ecoshipping.dto;


import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
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
    private String indirizzoPartenza;
    private String indirizzoConsegna;
    private float volumeSpedizione;
    private int numTelefonoDestinatario;
    private String metodoPagamento;
    private String noteConsegna;
    private String fasciaOraria;
    private float costoFinale;

}
