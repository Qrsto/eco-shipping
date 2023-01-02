package it.poliba.is45.ecoshipping.service;
import it.poliba.is45.ecoshipping.domain.Ordine;

import it.poliba.is45.ecoshipping.domain.TabellaConfigurazione;
import it.poliba.is45.ecoshipping.dto.OrdineDto;



import it.poliba.is45.ecoshipping.enumeratives.FasciaOraria;
import it.poliba.is45.ecoshipping.enumeratives.MetodoPagamento;
import it.poliba.is45.ecoshipping.repository.OrdineRepository;

import it.poliba.is45.ecoshipping.repository.TabellaConfigurazioneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class OrdineService {

    @Autowired
    OrdineRepository ordineRepository;
    @Autowired
    private TabellaConfigurazioneRepository tabellaConfigurazioneRepository;


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
        newOrdine.setCostoFinale(0.0F);
        return newOrdine;
    }



    public Ordine createNewOrder (OrdineDto ordineDto){
        Ordine newOrdine = utilsForCreation(ordineDto);
        return ordineRepository.save(newOrdine);

    }

    public List<OrdineDto> findAllOrders() {
        List<Ordine> ordineList = ordineRepository.findAll();
        List<OrdineDto> ordineDtoList = new ArrayList<>();
        for (Ordine ordine : ordineList) {
            OrdineDto ordineDto = toOrdineDto(ordine);
            ordineDtoList.add(ordineDto);
        }
        return ordineDtoList;
    }

    private OrdineDto toOrdineDto(Ordine ordine) {
        OrdineDto ordineDto = new OrdineDto();
        ordineDto.setIdOrdine(ordine.getIdOrdine());
        ordineDto.setIdSpedizione(ordine.getIdSpedizione());
        ordineDto.setIndirizzoPartenza(ordine.getIndirizzoPartenza());
        ordineDto.setIndirizzoConsegna(ordine.getIndirizzoConsegna());
        ordineDto.setPesoSpedizione(ordine.getPesoSpedizione());
        ordineDto.setVolumeSpedizione(ordine.getVolumeSpedizione());
        ordineDto.setNumTelefonoDestinatario(ordine.getNumTelefonoDestinatario());
        ordineDto.setMetodoPagamento(ordine.getMetodoPagamento());
        ordineDto.setFasciaOraria(ordine.getFasciaOraria());
        ordineDto.setNoteConsegna(ordine.getNoteConsegna());
        ordineDto.setCostoFinale(ordine.getCostoFinale());
        return ordineDto;
    }

    private HashMap<String,Float> toHashMapFloat () {
        HashMap<String, Float> toHashMapFloat = new LinkedHashMap<>();
        List<TabellaConfigurazione> tabellaConfigurazioneList = tabellaConfigurazioneRepository.findAll();
        for (TabellaConfigurazione tab : tabellaConfigurazioneList) {
            toHashMapFloat.put(tab.getConfKey(), Float.parseFloat(tab.getConfValue()));
        }
        return toHashMapFloat;
    }


    private float calculatePrezzoFinaleUtils(OrdineDto ordine){
        HashMap<String, Float> hashMapTab = toHashMapFloat();
        float numeroKm = 3F;   //da fare forumla (dalla latitudine/longitudine di partenza e arrivo si fa la diff e si calcola il numero km)
        float prezzoFinale = (float) (hashMapTab.get("costo_base") + (ordine.getPesoSpedizione()/100.00)
                                *hashMapTab.get("costo_100_grammi") + numeroKm*hashMapTab.get("costo_km"));
        return prezzoFinale;
    }





/*
    public float calculatePrezzoFinale(Ordine ordine) {
        return ordineRepository.updateCostoFinaleBy(calculatePrezzoFinaleUtils(ordine));
    }
*/
}

//FORMULA: prezzo finale = 2(COSTOFISSO) + (peso_pacco/100)*costo_100g + (nmK*costoKm)
