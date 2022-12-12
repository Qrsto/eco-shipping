package it.poliba.is45.ecoshipping.controller;



import it.poliba.is45.ecoshipping.dto.TabellaConfigurazioneDto;
import it.poliba.is45.ecoshipping.service.TabellaConfigurazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TabellaConfigurazioneController {

    @Autowired
    TabellaConfigurazioneService tabellaConfigurazioneService;

    @GetMapping("/tabelladiconfigurazione")
        public ResponseEntity<List<TabellaConfigurazioneDto>> findTabellaConfigurazione() {
            List<TabellaConfigurazioneDto> tabellaConfigurazioneDtoList = tabellaConfigurazioneService.getTabellaConfigurazione();
            return ResponseEntity.ok(tabellaConfigurazioneDtoList);
        }





    /* ---da aggiornare
    @PostMapping("/costo_spedizione/{peso_pacco_in_grammi}/{km}")
    public @ResponseBody String addNewCost_Spedizione (@PathVariable String peso_pacco_in_grammi, @PathVariable String km)
    TabellaConfigurazioneDto() n = new TabellaConfigurazioneDto();
    n.getConf_key(); Etichetta Esempio Costo_100_grammi
    n.getConf_value(); Valore Esempio 0.25€ nel caso di Costo_100_grammi
        
        Aggiungi Costo_Finale
    
    return 2 + ((peso_pacco_in_grammi/100)*n.getConf_value()) + (km*n.getConf_value());
    */
    /*DOMANDA: Come ricavo che Conf_value sia uguale a 0.25 nel caso di peso in grammi?*/
  }

/*
    @PostMapping("/costo_spedizione/peso_pacco_in_grammi/km")
    public ResponseEntity String addNewCost_Spedizione(@RequestParam String peso_pacco_in_grammi,@RequestParam String km) {
        TabellaConfigurazioneDto n = new TabellaConfigurazioneDto();
        n.getConf_key(); Etichetta Esempio Costo_100_grammi
        n.getConf_value(); /*Valore Esempio 0.25€ nel caso di Costo_100_grammi*

        /*DOMANDA: Come ricavo che Conf_value sia uguale a 0.25 nel caso di peso in grammi?*/





