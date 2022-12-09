package it.poliba.is45.ecoshipping.service;

import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    UtenteRepository utenteRepository;

    //per la psw come gestirla (in un metodo) inserire il campo in UtenteDto ???
    //vedi metodo creazioneUtenti


    private UtenteDto toUtenteDto(Utente utente){
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setIdUtente(utente.getIdUtente());
        utenteDto.setNome(utente.getNome());
        utenteDto.setCognome(utente.getCognome());
        utenteDto.setIndirizzoResidenza(utente.getIndirizzoResidenza());
        utenteDto.setCitta(utenteDto.getCitta());
        utenteDto.setCap(utente.getCap());
        utenteDto.setNumTelefono(utente.getNumTelefono());
        return utenteDto;
    }

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

    /*
    public UtenteDto findUtenteById(long id) {
        Utente utente = utenteRepository.findUtenteById(id);
        UtenteDto utenteDto = new UtenteDto();
        for (Utente utente : utenteList) {

        }


    }
    Come si gestisce il metodo ???
*/

    public Utente createNewClientUser(UtenteDto utenteDto) {
        Utente newUser = utilsForCreation(utenteDto);
        newUser.setTipoUtente(TipoUtente.CLIENTE);
        return utenteRepository.save(newUser);

        }


    public Utente createNewRiderUser(UtenteDto utenteDto) {
        Utente newUser = utilsForCreation(utenteDto);
        newUser.setTipoUtente(TipoUtente.RIDER);
        return utenteRepository.save(newUser);
    }

    public Utente createNewAdminUser(UtenteDto utenteDto) {
        Utente newUser = utilsForCreation(utenteDto);
        newUser.setTipoUtente(TipoUtente.ADMIN);
        return utenteRepository.save(newUser);
    }

    private Utente utilsForCreation(UtenteDto utenteDto) {
        Utente newUser = new Utente();
        newUser.setNome(utenteDto.getNome());
        newUser.setCognome(utenteDto.getCognome());
        newUser.setCap(utenteDto.getCap());
        newUser.setCitta(utenteDto.getCitta());
        newUser.setIndirizzoResidenza(utenteDto.getIndirizzoResidenza());
        newUser.setDataNasc(utenteDto.getDataNas());
        newUser.setNumTelefono(utenteDto.getNumTelefono());
        newUser.setPassword(utenteDto.getPassword());
        newUser.setDisponibilitaLavoro(false);
        newUser.setIBAN(utenteDto.getIban());
        newUser.setLongitudineRider(0);
        newUser.setLatitudineRider(0);

        return newUser;
    }

    /*
    public String deleteAllUser() {
        utenteRepository.deleteAll();
        return "DB vuoto";
    }
     */











    }

