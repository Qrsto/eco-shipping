package it.poliba.is45.ecoshipping.service;

import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtenteService {
    @Autowired
    UtenteRepository utenteRepository;

    //restituisce una lista di utentiDTO (vedi UtenteDto) che hanno lo specifico tipoUtente passato al metodo
    public List<UtenteDto> findAllByTipoUtente(TipoUtente tipoUtente) {
        List<Utente> utenteList = utenteRepository.findAllByTipoUtente(tipoUtente);
        List<UtenteDto> utenteDtoList = new ArrayList<>();
        for (Utente utente: utenteList) {
            UtenteDto utenteDto = new UtenteDto();
            utenteDto.setIdUtente(utente.getIdUtente());
            utenteDto.setNome(utente.getNome());
            utenteDto.setCognome(utente.getCognome());
            utenteDto.setIndirizzoResidenza(utente.getIndirizzoResidenza());
            utenteDto.setCitta(utente.getCitta());
            utenteDto.setCap(utente.getCap());
            utenteDto.setDataNas(utente.getDataNasc());
            utenteDto.setNumTelefono(utente.getNumTelefono());
            utenteDtoList.add(utenteDto);
        }
        return utenteDtoList;

    }


    //ottimizzare magari estendendo a qualsiasi tipoUtente (con degli if...)
    public Utente createNewClientUser(Utente utenteDto) {
        Utente newUser = new Utente();
        newUser.setNome(utenteDto.getNome());
        newUser.setCognome(utenteDto.getCognome());
        newUser.setCap(utenteDto.getCap());
        newUser.setCitta(utenteDto.getCitta());
        newUser.setIndirizzoResidenza(utenteDto.getIndirizzoResidenza());
        newUser.setDataNasc(utenteDto.getDataNasc());
        newUser.setNumTelefono(utenteDto.getNumTelefono());
        newUser.setPassword(utenteDto.getPassword());
        newUser.setDisponibilitaLavoro(false);
        newUser.setIBAN(null);
        newUser.setTipoUtente(TipoUtente.CLIENTE);
        newUser.setLongitudineRider(0);
        newUser.setLatitudineRider(0);

        return newUser;

    }
/*
    public List<UtenteDto> findAllByNome(Utente utente) {
        //fare prima METODO DI INSERIMENTO
        List<Utente> utenteList = utenteRepository.findAllByNome(utente);
        List<Utente> utenteListCopy = new ArrayList<>();
        return utenteList;
    }
*/



    }

