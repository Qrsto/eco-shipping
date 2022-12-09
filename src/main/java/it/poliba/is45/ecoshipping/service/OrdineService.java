package it.poliba.is45.ecoshipping.service;
import it.poliba.is45.ecoshipping.domain.Ordine;
import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.dto.OrdineDto;

import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
import it.poliba.is45.ecoshipping.repository.OrdineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdineService {

    @Autowired
    OrdineRepository ordineRepository;

    private Ordine utilsForCreation (OrdineDto ordineDto){
        Ordine newOrdine = new Ordine();
        newOrdine.setIdOrdine(ordineDto.getIdOrdine());
        newOrdine.setIndirizzoPartenza(ordineDto.getIndirizzoPartenza());
        newOrdine.setIndirizzoConsegna(ordineDto.getIndirizzoConsegna());
        newOrdine.setVolumeSpedizione(ordineDto.getVolumeSpedizione());
        newOrdine.setFasciaOraria(ordineDto.getFasciaOraria());
        newOrdine.setNoteConsegna(ordineDto.getNoteConsegna());
        newOrdine.setNumTelefonoDestinatario(ordineDto.getNumTelefonoDestinatario());
        newOrdine.setMetodoPagamento(ordineDto.getMetodoPagamento());
        newOrdine.setCostoFinale(ordineDto.getCostoFinale());

        return newOrdine;
    }

    public Ordine createNewOrder (OrdineDto ordineDto){
        Ordine newOrdine = utilsForCreation(ordineDto);
        return ordineRepository.save(newOrdine);

    }

}
