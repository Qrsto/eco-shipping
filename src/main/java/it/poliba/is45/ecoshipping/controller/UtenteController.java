package it.poliba.is45.ecoshipping.controller;


import it.poliba.is45.ecoshipping.Enum.TipoUtente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.poliba.is45.ecoshipping.domain.Utente;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class UtenteController {


    //ho creato un ArrayList che contiene tutti gli utenti registrati e poi un GetMapping /utenti per visualizzare tutti gli utenti
    //ho usato package random per generare stringhe e numeri casuali
    //TO DO: discutere sulla struttura dati da implementare per la gestione degli utenti (e anche poi spedizioni) in questo esempio vi è arraylist
    @RequestMapping("/utenti")
    public String getAllUsers () {
        Random r = new Random();


        List<Utente> utenti = new ArrayList<>();
        utenti.add(new Utente(r.nextLong(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),TipoUtente.ADMIN,r.nextLong(),r.nextDouble(),r.nextBoolean()));
        utenti.add(new Utente(r.nextLong(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),TipoUtente.RIDER,r.nextLong(),r.nextDouble(),r.nextBoolean()));
        utenti.add(new Utente(r.nextLong(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(),r.toString(), TipoUtente.ADMIN,r.nextLong(),r.nextDouble(),r.nextBoolean()));

        return utenti.toString();
    }

}
