package it.poliba.is45.ecoshipping.controller;

import it.poliba.is45.ecoshipping.dto.OrdineDto;
import it.poliba.is45.ecoshipping.dto.SpedizioneDto;
import it.poliba.is45.ecoshipping.service.SpedizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/api/shipment")
public class SpedizioneController {

    @Autowired
    SpedizioneService spedizioneService;

    @GetMapping("/shipments")
    ResponseEntity<List<SpedizioneDto>> getAllShipments () {
        List<SpedizioneDto> spedizioneDtoList = spedizioneService.findAllShipments();
        return ResponseEntity.ok(spedizioneDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpedizioneDto> getSpedizioneById (@PathVariable int id){
        try{
            SpedizioneDto spedizioneDto = spedizioneService.findSpedizioneById(id);
            return ResponseEntity.ok(spedizioneDto);
        } catch (RuntimeException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    
}
