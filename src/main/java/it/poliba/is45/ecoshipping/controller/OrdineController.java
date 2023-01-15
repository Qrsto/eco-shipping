package it.poliba.is45.ecoshipping.controller;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import it.poliba.is45.ecoshipping.domain.Ordine;

import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.dto.OrdineDto;

import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.service.OrdineService;
import it.poliba.is45.ecoshipping.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/api/order")

public class OrdineController {


    @Autowired
    OrdineService ordineService;
    UtenteService utenteService;

    @GetMapping("/orders")
    ResponseEntity<List<OrdineDto>> getAllOrders () {
        List<OrdineDto> ordineDtoList = ordineService.findAllOrders();
        return ResponseEntity.ok(ordineDtoList);
    }

    @PostMapping("/new")
    public ResponseEntity<Ordine> createNewOrder(@RequestBody @Valid OrdineDto ordineDto) {
        return ResponseEntity.ok(ordineService.createNewOrder(ordineDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdineDto> getOrderById (@PathVariable int id){
        try{
            OrdineDto ordineDto = ordineService.findOrdineById(id);
            return ResponseEntity.ok(ordineDto);
        } catch (RuntimeException exception) {
            exception.printStackTrace();
            return null;
        }
    }


    @GetMapping("/userorders/{id_utente}")
    public ResponseEntity<List<OrdineDto>> getOrderById_utente (@PathVariable int id_utente){
        try{
            List<OrdineDto> ordineDtolist = ordineService.findOrdineById_Utente(id_utente);
            return ResponseEntity.ok(ordineDtolist);
        } catch (RuntimeException exception) {
            exception.printStackTrace();
            return null;
        }
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



}
