package it.poliba.is45.ecoshipping.controller;
import java.util.concurrent.atomic.AtomicLong;

import it.poliba.is45.ecoshipping.domain.Ordine;
import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.dto.OrdineDto;
import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdineController {

    @Autowired
    OrdineService ordineService;

    @PostMapping("/ordine/neworder")
    public ResponseEntity<Ordine> createNewOrder(@RequestBody OrdineDto ordineDto) {
        return ResponseEntity.ok(ordineService.createNewOrder(ordineDto));
    }

}
