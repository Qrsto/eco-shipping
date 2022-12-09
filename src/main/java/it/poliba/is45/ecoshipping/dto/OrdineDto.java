package it.poliba.is45.ecoshipping.dto;


import it.poliba.is45.ecoshipping.enumeratives.FasciaOraria;
import it.poliba.is45.ecoshipping.enumeratives.MetodoPagamento;
import it.poliba.is45.ecoshipping.enumeratives.TipoStato;
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

    //discutere sulle FK (come gestirle)
    private int idOrdine;
    private String indirizzoPartenza;
    private String indirizzoConsegna;
    private float volumeSpedizione;
    private float pesoSpedizione;
    private int numTelefonoDestinatario;
    private MetodoPagamento metodoPagamento;
    private FasciaOraria fasciaOraria;
    private String noteConsegna;
    private float costoFinale;

}
