package it.poliba.is45.ecoshipping.service;

import it.poliba.is45.ecoshipping.domain.Ordine;
import it.poliba.is45.ecoshipping.domain.Spedizione;
import it.poliba.is45.ecoshipping.dto.OrdineDto;
import it.poliba.is45.ecoshipping.dto.SpedizioneDto;
import it.poliba.is45.ecoshipping.repository.OrdineRepository;
import it.poliba.is45.ecoshipping.repository.SpedizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpedizioneService {

    @Autowired
    SpedizioneRepository spedizioneRepository;

    private SpedizioneDto toSpedizioneDto(Spedizione spedizione) {
        SpedizioneDto spedizioneDto = new SpedizioneDto();
        spedizioneDto.setId(spedizione.getIdOrdine());
        spedizioneDto.setTipoStato(spedizione.getTipoStato());
        spedizioneDto.setIdRider(spedizione.getIdRider());
        spedizioneDto.setDataEvasione(spedizione.getDataOraEvasione());
        spedizioneDto.setId_utente(spedizione.getUtente().getIdUtente());
        return spedizioneDto;
    }

    public List<SpedizioneDto> findAllShipments() {
        List<Spedizione> spedizioneList = spedizioneRepository.findAll();
        List<SpedizioneDto> spedizioneDtoList = new ArrayList<>();
        for (Spedizione spedizione : spedizioneList) {
            SpedizioneDto spedizioneDto = toSpedizioneDto(spedizione);
            spedizioneDtoList.add(spedizioneDto);
        }
        return spedizioneDtoList;
    }

    public SpedizioneDto findSpedizioneById (int id)  {
        Optional<Spedizione> spedizione = spedizioneRepository.findById(id);
        if (spedizione.isPresent()) {
            SpedizioneDto spedizioneDto = toSpedizioneDto(spedizione.get());
            return spedizioneDto;
        }
        else{

            SpedizioneDto spedizione2 = new SpedizioneDto();
            spedizione2.setId_utente(0);
            spedizione2.setDataEvasione(null);
            spedizione2.setIdRider(0);
            spedizione2.setTipoStato(null);
            spedizione2.setId_utente(0);
            return spedizione2;


        }


    }

}
