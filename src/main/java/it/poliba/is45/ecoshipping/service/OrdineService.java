package it.poliba.is45.ecoshipping.service;
import it.poliba.is45.ecoshipping.domain.Ordine;

import it.poliba.is45.ecoshipping.dto.OrdineDto;


import it.poliba.is45.ecoshipping.enumeratives.FasciaOraria;
import it.poliba.is45.ecoshipping.enumeratives.MetodoPagamento;
import it.poliba.is45.ecoshipping.repository.OrdineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        newOrdine.setPesoSpedizione(ordineDto.getPesoSpedizione());
        newOrdine.setFasciaOraria(FasciaOraria.MATTINA);
        newOrdine.setNoteConsegna(ordineDto.getNoteConsegna());
        newOrdine.setNumTelefonoDestinatario(ordineDto.getNumTelefonoDestinatario());
        newOrdine.setMetodoPagamento(MetodoPagamento.CONTANTI);
        newOrdine.setCostoFinale(ordineDto.getCostoFinale());
        newOrdine.setIdUtente(37);
        return newOrdine;
    }

    public Ordine createNewOrder (OrdineDto ordineDto){
        Ordine newOrdine = utilsForCreation(ordineDto);
        return ordineRepository.save(newOrdine);

    }

}
