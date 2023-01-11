package it.poliba.is45.ecoshipping.controller;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import it.poliba.is45.ecoshipping.domain.Ordine;

import it.poliba.is45.ecoshipping.dto.OrdineDto;

import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/order")
@PreAuthorize("hasRole('ROLE_CLIENT') or hasRole('ROLE_RIDER') or hasRole('ROLE_ADMIN')")
public class OrdineController {


    @Autowired
    OrdineService ordineService;

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
    public ResponseEntity<OrdineDto> getOrderById (@PathVariable int id) {
        try{
            OrdineDto ordineDto = ordineService.findOrdineById(id);
            return ResponseEntity.ok(ordineDto);
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
