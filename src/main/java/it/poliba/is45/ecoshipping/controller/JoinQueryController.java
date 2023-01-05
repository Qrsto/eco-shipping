package it.poliba.is45.ecoshipping.controller;

import it.poliba.is45.ecoshipping.service.JoinQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
