package it.poliba.is45.ecoshipping.service;
import it.poliba.is45.ecoshipping.domain.Ordine;

import it.poliba.is45.ecoshipping.domain.TabellaConfigurazione;
import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.dto.OrdineDto;


import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.enumeratives.FasciaOraria;
import it.poliba.is45.ecoshipping.enumeratives.MetodoPagamento;
import it.poliba.is45.ecoshipping.repository.OrdineRepository;

import it.poliba.is45.ecoshipping.repository.TabellaConfigurazioneRepository;

import it.poliba.is45.ecoshipping.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrdineService {

    @Autowired
    OrdineRepository ordineRepository;
    @Autowired
    UtenteRepository utenteRepository;
    @Autowired
    private TabellaConfigurazioneRepository tabellaConfigurazioneRepository;


    private Ordine utilsForCreation (OrdineDto ordineDto){
        Ordine newOrdine = new Ordine();
        Utente user = new Utente();
        user.setIdUtente(ordineDto.getId_utente());
        newOrdine.setUtente(user);
        newOrdine.setIdOrdine(ordineDto.getIdOrdine());
        newOrdine.setIndirizzoPartenza(ordineDto.getIndirizzoPartenza());
        newOrdine.setIndirizzoConsegna(ordineDto.getIndirizzoConsegna());
        newOrdine.setVolumeSpedizione(ordineDto.getVolumeSpedizione());
        newOrdine.setPesoSpedizione(ordineDto.getPesoSpedizione());
        newOrdine.setFasciaOraria(ordineDto.getFasciaOraria());
        newOrdine.setNoteConsegna(ordineDto.getNoteConsegna());
        newOrdine.setNumTelefonoDestinatario(ordineDto.getNumTelefonoDestinatario());
        newOrdine.setMetodoPagamento(ordineDto.getMetodoPagamento());
        newOrdine.setCostoFinale(0.0F);
        newOrdine.setLongitudinePartenza(0.0);
        newOrdine.setLatitudinePartenza(0.0);
        newOrdine.setLongitudineDestinazione(0.0);
        newOrdine.setLatitudineDestinazione(0.0);
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

    public OrdineDto findOrdineById (int id)  {
        Optional<Ordine> ordine = ordineRepository.findById(id);
        if (ordine.isPresent()) {
            OrdineDto ordineDto = toOrdineDto(ordine.get());
            return ordineDto;
        }
        else
            throw new RuntimeException("Nessun ordine trovato con id:  " + id);

    }

    public List<OrdineDto> findOrdineById_Utente (int id_utente)  {

        List<Utente> utentelist = utenteRepository.findAll();
        UtenteDto user = null;
        for (Utente utente : utentelist){

            if(utente.getIdUtente() == id_utente){

                UtenteDto utenteDto = toUtenteDto(utente);
                user = utenteDto;

            }

        }
        int x = user.getIdUtente();
        List<Ordine> ordinelist = ordineRepository.findAll();
        List<OrdineDto> ordineDtoList = new ArrayList<>();
        for (Ordine ordine : ordinelist) {

            if(ordine.getUtente().getIdUtente() == x){

                OrdineDto ordineDto = toOrdineDto(ordine);
                ordineDtoList.add(ordineDto);

            }

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
        ordineDto.setLongitudinePartenza(ordine.getLongitudinePartenza());
        ordineDto.setLatitudinePartenza(ordine.getLatitudinePartenza());
        ordineDto.setLongitudineDestinazione(ordine.getLongitudineDestinazione());
        ordineDto.setLatitudineDestinazione(ordine.getLatitudineDestinazione());
        ordineDto.setId_utente(ordine.getUtente().getIdUtente());
        return ordineDto;
    }

    private UtenteDto toUtenteDto(Utente utente) {
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setIdUtente(utente.getIdUtente());
        utenteDto.setNome(utente.getNome());
        utenteDto.setCognome(utente.getCognome());
        utenteDto.setIndirizzoResidenza(utente.getIndirizzoResidenza());
        utenteDto.setCitta(utenteDto.getCitta());
        utenteDto.setCap(utente.getCap());
        utenteDto.setIban(utente.getIban());
        utenteDto.setUsername(utente.getUsername());
        utenteDto.setDataNas(utente.getDataNasc());
        return utenteDto;
    }

    private HashMap<String,Float> toHashMapFloat () {
        HashMap<String, Float> toHashMapFloat = new LinkedHashMap<>();
        List<TabellaConfigurazione> tabellaConfigurazioneList = tabellaConfigurazioneRepository.findAll();
        for (TabellaConfigurazione tab : tabellaConfigurazioneList) {
            toHashMapFloat.put(tab.getConfKey(), Float.parseFloat(tab.getConfValue()));
        }
        return toHashMapFloat;
    }



    //distanceInKm: caclcola la distanza dati tre punti (partenza Rider, (arrivoRider) PartenzaOrdine, ArrivoOrdine)
    private static double distanceInKm(Utente utente, Ordine ordine) {
        //dichiarazione vettori come se fossero coordinate Gamma = {x,y}
        Double[] a = {utente.getLatitudineRider(), utente.getLongitudineRider()};
        Double[] b = {ordine.getLatitudinePartenza(), ordine.getLongitudinePartenza()};
        Double[] c = {ordine.getLatitudineDestinazione(), ordine.getLongitudineDestinazione()};
        for(int i=0; i<2; i++ ){
            a[i] = Math.toRadians(a[i]);
            b[i] = Math.toRadians(b[i]);
            c[i] = Math.toRadians(c[i]);
        }
        //formula di Haversine
        double dLat = b[0] - a[0];
        double dLon = b[1] - a[1];
        double s = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(a[0]) * Math.cos(b[0]);
        //o sommo o oppure posso inglobare la somma facendo dopo l'arrotondamento per round e dividendo per 100
        double distA_B = Math.round((2.00 * Math.asin(Math.sqrt(s)) * 6371.00) * 100.0) / 100.0 ;

        dLat = c[0] - b[0];
        dLon = c[1] - b[1];
        s = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(b[0]) * Math.cos(c[0]);
        double distB_C = Math.round((2.00 * Math.asin(Math.sqrt(s)) * 6371.00) * 100.0) / 100.0;
        double distTot = distA_B + distB_C;
        return distTot;
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
