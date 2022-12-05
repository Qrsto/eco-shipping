package it.poliba.is45.ecoshipping.controller;


import it.poliba.is45.ecoshipping.Enum.TipoUtente;
import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
