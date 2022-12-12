package it.poliba.is45.ecoshipping.service;

import it.poliba.is45.ecoshipping.domain.TabellaConfigurazione;
import it.poliba.is45.ecoshipping.dto.TabellaConfigurazioneDto;
import it.poliba.is45.ecoshipping.repository.TabellaConfigurazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TabellaConfigurazioneService {
    @Autowired
    TabellaConfigurazioneRepository tabellaConfigurazioneRepository;

    //si potrebbe creare un package Utils con i vari metodi (sotto)
    public List<TabellaConfigurazioneDto> getTabellaConfigurazione(){
        List<TabellaConfigurazione> tabellaConfigurazioneList =  tabellaConfigurazioneRepository.findAll();
        List<TabellaConfigurazioneDto> tabellaConfigurazioneDtoList = new ArrayList<>();
        for (TabellaConfigurazione tab : tabellaConfigurazioneList ) {
            TabellaConfigurazioneDto tabellaConfigurazioneDto = new TabellaConfigurazioneDto();
            tabellaConfigurazioneDto.setConfKey(tab.getConfKey());
            tabellaConfigurazioneDto.setConfValue(tab.getConfValue());
            tabellaConfigurazioneDtoList.add(tabellaConfigurazioneDto);
        }
        return tabellaConfigurazioneDtoList;
    }


}
