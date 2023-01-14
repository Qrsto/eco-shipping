package it.poliba.is45.ecoshipping.controller;


import it.poliba.is45.ecoshipping.domain.ERole;
import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/api/utente")
public class UtenteController {

    @Autowired
    UtenteService utenteService;

    @GetMapping ("/getallutenti")
    public ResponseEntity<List<UtenteDto>> getAllUsers(){
        List<UtenteDto> utenteDtoList = utenteService.findAllUsers();
        return ResponseEntity.ok(utenteDtoList);
    }
  /*  @GetMapping ("/utente/clienti")
    public ResponseEntity<List<UtenteDto>> getAllClientUsers () {
       List<UtenteDto> utenteDtoList = utenteService.findAllByRole(ERole.ROLE_USER);
       return ResponseEntity.ok(utenteDtoList);
    }

    @GetMapping ("/utente/riders")
    public ResponseEntity<List<UtenteDto>> getAllRiderUsers () {
        List<UtenteDto> utenteDtoList = utenteService.findAllByRole(ERole.ROLE_RIDER);
        return ResponseEntity.ok(utenteDtoList);
    }

    @GetMapping ("/utente/admin")
    public ResponseEntity<List<UtenteDto>> getAllAdminUsers () {
        List<UtenteDto> utenteDtoList = utenteService.findAllByRole(ERole.ROLE_ADMIN);
        return ResponseEntity.ok(utenteDtoList);
    }

   */

    @GetMapping("/{id}")
    public ResponseEntity<UtenteDto> getUserById (@PathVariable Long id) {
        try{
            UtenteDto utenteDto = utenteService.findUtenteById(id);
            return ResponseEntity.ok(utenteDto);
        } catch (RuntimeException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<UtenteDto> getUserByUsername (@PathVariable String username) {
        try{
            UtenteDto utenteDto = utenteService.findUtenteByUsername(username);
            return ResponseEntity.ok(utenteDto);
        } catch (RuntimeException exception) {
            exception.printStackTrace();
            return null;
        }
    }




}



    //come gestire le operazioni admin???
    /*
    @DeleteMapping("/gestione")
    public ResponseEntity<String> deleteAllUser() {
        return ResponseEntity.ok(utenteService.deleteAllUser());
    }
     */

