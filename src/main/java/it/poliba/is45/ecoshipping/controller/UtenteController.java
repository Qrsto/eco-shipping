package it.poliba.is45.ecoshipping.controller;


import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtenteController {

    @Autowired
    UtenteService utenteService;

    @GetMapping ("/utenti/clienti")
    public ResponseEntity<List<UtenteDto>> getAllUsers () {
       List<UtenteDto> utenteDtoList = utenteService.findAllByTipoUtente(TipoUtente.CLIENTE);
       return ResponseEntity.ok(utenteDtoList);
    }

    @PostMapping("utenti/nuovoCliente")
    public ResponseEntity<Utente> createNewClientUser(@RequestBody UtenteDto utenteDto) {
       return ResponseEntity.ok(utenteService.createNewClientUser(utenteDto));
    }

    @PostMapping("utenti/nuovoRider")
    public ResponseEntity<Utente> createNewRiderUser(@RequestBody UtenteDto utenteDto) {
        return ResponseEntity.ok(utenteService.createNewRiderUser(utenteDto));
    }

    @PostMapping("utenti/nuovoAdmin")
    public ResponseEntity<Utente> createNewAdminUser(@RequestBody UtenteDto utenteDto) {
        return ResponseEntity.ok(utenteService.createNewAdminUser(utenteDto));
    }






}
