package it.poliba.is45.ecoshipping.dto;

import it.poliba.is45.ecoshipping.enumeratives.TipoStato;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SpedizioneDto {

    private int id;
    private LocalDateTime dataEvasione;
    private int idRider;
    private TipoStato tipoStato;
    private int id_utente;

}
