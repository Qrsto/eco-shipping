package it.poliba.is45.ecoshipping.controller;
import java.util.concurrent.atomic.AtomicLong;

import it.poliba.is45.ecoshipping.domain.Ordine;
import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.dto.OrdineDto;
import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.repository.OrdineRepository;
import it.poliba.is45.ecoshipping.repository.UtenteRepository;
import it.poliba.is45.ecoshipping.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdineController {

    @Autowired
    OrdineService ordineService;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private OrdineRepository ordineRepository;

<<<<<<< HEAD

=======
    @PostMapping("/ordine/neworder")
    public ResponseEntity<Ordine> createNewOrder(@RequestBody OrdineDto ordineDto) {
        return ResponseEntity.ok(ordineService.createNewOrder(ordineDto));
    }
/*
    @PutMapping("/ordine/costofinale")
    public ResponseEntity<Ordine> updateCostoFinale(@PathVariable(value = "id_ordine") int id, @RequestBody float prezzoFinale) {
        Ordine ordine = ordineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordine non trovato con id: " + id));
        ordine.setCostoFinale(ordineService.calculatePrezzoFinale(ordine));
        final Ordine updatedOrdine = ordineRepository.save(ordine);
        return ResponseEntity.ok(updatedOrdine);
    }
*/
>>>>>>> 6ca283a43e0145288efa590c488aced7fe02aec5
}
