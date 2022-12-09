package it.poliba.is45.ecoshipping.controller;


import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UtenteController {

    @Autowired
    UtenteService utenteService;

    @GetMapping ("/utente/clienti")
    public ResponseEntity<List<UtenteDto>> getAllClientUsers () {
       List<UtenteDto> utenteDtoList = utenteService.findAllByTipoUtente(TipoUtente.CLIENTE);
       return ResponseEntity.ok(utenteDtoList);
    }

    @GetMapping ("/utente/riders")
    public ResponseEntity<List<UtenteDto>> getAllRiderUsers () {
        List<UtenteDto> utenteDtoList = utenteService.findAllByTipoUtente(TipoUtente.RIDER);
        return ResponseEntity.ok(utenteDtoList);
    }

    @GetMapping ("/utente/admin")
    public ResponseEntity<List<UtenteDto>> getAllAdminUsers () {
        List<UtenteDto> utenteDtoList = utenteService.findAllByTipoUtente(TipoUtente.ADMIN);
        return ResponseEntity.ok(utenteDtoList);
    }

    @GetMapping("/utente/{idUtente}")
    public ResponseEntity<Optional<UtenteDto>> getUserById(@PathVariable int id) {
        Optional<UtenteDto> utenteDto = utenteService.findUtenteById(id);
        return ResponseEntity.ok(utenteDto);
    }


    @PostMapping("/utente/nuovocliente")
    public ResponseEntity<Utente> createNewClientUser(@RequestBody UtenteDto utenteDto) {
       return ResponseEntity.ok(utenteService.createNewClientUser(utenteDto));
    }

    @PostMapping("/utente/nuovorider")
    public ResponseEntity<Utente> createNewRiderUser(@RequestBody UtenteDto utenteDto) {
        return ResponseEntity.ok(utenteService.createNewRiderUser(utenteDto));
    }

    @PostMapping("/utente/nuovoadmin")
    public ResponseEntity<Utente> createNewAdminUser(@RequestBody UtenteDto utenteDto) {
        return ResponseEntity.ok(utenteService.createNewAdminUser(utenteDto));
    }



    //come gestire le operazioni admin???
    /*
    @DeleteMapping("/gestione")
    public ResponseEntity<String> deleteAllUser() {
        return ResponseEntity.ok(utenteService.deleteAllUser());
    }
     */



    /*
    @PostMapping("/utenti/{id_utente}")
    public Optional<UtenteDto> findUtenteById(@PathVariable long id) {
        return utenteService.findUtenteById(id);
    }

*/




}
