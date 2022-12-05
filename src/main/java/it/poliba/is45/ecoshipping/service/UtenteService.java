package it.poliba.is45.ecoshipping.service;

import it.poliba.is45.ecoshipping.Enum.TipoUtente;
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
            utenteDto.setDataNas(utente.getData_nas());
            utenteDtoList.add(utenteDto);
        }
        return utenteDtoList;

    }

}
