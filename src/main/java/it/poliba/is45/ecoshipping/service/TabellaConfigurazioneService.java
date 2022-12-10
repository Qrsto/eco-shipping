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

<<<<<<< HEAD
    //si potrebbe creare un package Utils con i vari metodi (sotto)
    public List<TabellaConfigurazioneDto> getTabellaConfigurazione(){
        List<TabellaConfigurazione> tabellaConfigurazioneList =  tabellaConfigurazioneRepository.getTabellaConfigurazione();
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
=======
    private TabellaConfigurazioneDto utilsForCreation (TabellaConfigurazione tabellaConfigurazione) {
>>>>>>> 44b3f4a997668d66dd9d65a73fcc9686df83a07d

        TabellaConfigurazioneDto tabellaConfigurazioneDto = new TabellaConfigurazioneDto();
        tabellaConfigurazioneDto.setConf_key(tabellaConfigurazione.getConfKey());
        tabellaConfigurazioneDto.setConf_value(tabellaConfigurazione.getConfValue());
        return tabellaConfigurazioneDto;

    }

}