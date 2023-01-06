package it.poliba.is45.ecoshipping.controller;


import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.service.UtenteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UtenteController {

    @Autowired
    UtenteService utenteService;

    @GetMapping ("/getallutenti")
    public ResponseEntity<List<UtenteDto>> getAllUsers(){
        List<UtenteDto> utenteDtoList = utenteService.findAllUsers();
        return ResponseEntity.ok(utenteDtoList);
    }
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

    @GetMapping("/utente/{id}")
    public ResponseEntity<UtenteDto> getUserById (@PathVariable int id) {
        try{
            UtenteDto utenteDto = utenteService.findUtenteById(id);
            return ResponseEntity.ok(utenteDto);
        } catch (RuntimeException exception) {
            exception.printStackTrace();
            return null;
        }
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



}

   /*
   https://www.bezkoder.com/jpa-repository-query/
   PER QUERY
    */









    //come gestire le operazioni admin???
    /*
    @DeleteMapping("/gestione")
    public ResponseEntity<String> deleteAllUser() {
        return ResponseEntity.ok(utenteService.deleteAllUser());
    }
     */

