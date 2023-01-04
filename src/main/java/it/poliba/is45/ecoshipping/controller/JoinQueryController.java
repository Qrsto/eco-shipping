package it.poliba.is45.ecoshipping.controller;

import it.poliba.is45.ecoshipping.domain.UtenteOrdini;
import it.poliba.is45.ecoshipping.dto.ClienteOrdineDto;
import it.poliba.is45.ecoshipping.service.JoinQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JoinQueryController {
    @Autowired
    private JoinQueryService joinQueryService;

/*
    @GetMapping(name = "/utente/ordine/inner")
    public ResponseEntity<List<ClienteOrdineDto>> getUsOrdersInnerJoin() {
        List<ClienteOrdineDto> clienteOrdineDtoList = joinQueryService.getUsOrdersInnerJoin();
        return ResponseEntity.ok(clienteOrdineDtoList);
    }

 */
}
