package it.poliba.is45.ecoshipping.service;

import it.poliba.is45.ecoshipping.domain.Ordine;
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


    private UtenteDto toUtenteDto(Utente utente) {
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setIdUtente(utente.getIdUtente());
        utenteDto.setNome(utente.getNome());
        utenteDto.setCognome(utente.getCognome());
        utenteDto.setIndirizzoResidenza(utente.getIndirizzoResidenza());
        utenteDto.setCitta(utenteDto.getCitta());
        utenteDto.setCap(utente.getCap());
        utenteDto.setNumTelefono(utente.getNumTelefono());
        utenteDto.setPassword(utente.getPassword());
        utenteDto.setIban(utente.getIban());  //devi sempre gestire la visualizzazione dell'iban in base al caso (vedi findAllByTipoUtente)
        return utenteDto;
    }

    //restituisce una lista di utentiDTO (vedi UtenteDto) che hanno lo specifico tipoUtente passato al metodo
    public List<UtenteDto> findAllByTipoUtente(TipoUtente tipoUtente) {
        List<Utente> utenteList = utenteRepository.findAllByTipoUtente(tipoUtente);
        List<UtenteDto> utenteDtoList = new ArrayList<>();
        for (Utente utente : utenteList) {
            UtenteDto utenteDto = toUtenteDto(utente);
            utenteDto.setIban("******************************");
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

    public UtenteDto findUtenteById (int id)  {
        Optional<Utente> utente = utenteRepository.findById(id);
        if (utente.isPresent()) {
            UtenteDto utenteDto = toUtenteDto(utente.get());
            return utenteDto;
        }
        else
            throw new RuntimeException("Nessun utente trovato con id:  " + id);

    }


    public Utente createNewClientUser (UtenteDto utenteDto) {
        Utente newUser = utilsForCreation(utenteDto);
        newUser.setTipoUtente(TipoUtente.CLIENTE);
        return utenteRepository.save(newUser);
    }
    public Utente createNewRiderUser (UtenteDto utenteDto) {
        Utente newUser = utilsForCreation(utenteDto);
        newUser.setTipoUtente(TipoUtente.RIDER);
        return utenteRepository.save(newUser);
    }

    public Utente createNewAdminUser (UtenteDto utenteDto) {
        Utente newUser = utilsForCreation(utenteDto);
        newUser.setTipoUtente(TipoUtente.ADMIN);
        return utenteRepository.save(newUser);
    }


    /* 41.11756379579976, 16.871091585638478 (Bari)
       44.52512585109125, 11.390366494774641 (Bologna)
       Δs = 591.07 km (circa)

     */


    private Utente utilsForCreation (UtenteDto utenteDto){
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
        newUser.setIban(utenteDto.getIban());
        newUser.setLongitudineRider(10.2548441);
        newUser.setLatitudineRider(12.25151);
        return newUser;
    }

    //trasforma coordinate in distanza tra tre punti
    //da completare

    private int distanceInKm(Utente utente, Ordine ordine) {
        Double[] a = {utente.getLatitudineRider(), utente.getLongitudineRider()};
        Double[] b = {ordine.getLatitudinePartenza(), ordine.getLongitudinePartenza()};
        Double[] c = {ordine.getLatitudineDestinazione(), ordine.getLongitudineDestinazione()};
        for(int i=0; i<2; i++ ){
            a[i] = Math.toRadians(a[i]);
            b[i] = Math.toRadians(b[i]);
            c[i] = Math.toRadians(c[i]);
        }
        double dLat = b[0]-a[0];
        double dLon = b[1]-a[1];
        //da completare
        double s = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(a[0]);
        return 0;
    }




    /*
    double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                   Math.pow(Math.sin(dLon / 2), 2) *
                   Math.cos(lat1) *
                   Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
     */





















       /*
    public String deleteAllUser() {
        utenteRepository.deleteAll();
        return "DB vuoto";
    }
     */


    }




