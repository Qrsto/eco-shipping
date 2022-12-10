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

    @GetMapping("/tabelladiconfigurazione/view")
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
    
    return 2 + ((peso_pacco_in_grammi/100)*n.getConf_value()) + (km*n.getConf_value());
    */
    /*DOMANDA: Come faccio a ricavare che Conf_value sia uguale a 0.25 nel caso di peso in grammi?*/
  }
        
  /*
/*FORMULA: prezzo finale = 2(COSTOFISSO) + (peso_pacco/100)*costo_100g + (nKm*costoKm)/

/* ESEMPIO: prezzo finale = 2€ + (1000/100)*0.25€ + (1*0.5€) = 5€
nKm = 1
peso = 1 kg
costo_100g = 0.25€
costoKm = 0.5€*/

