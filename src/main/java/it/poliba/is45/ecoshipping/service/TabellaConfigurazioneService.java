package it.poliba.is45.ecoshipping.service;

import it.poliba.is45.ecoshipping.domain.TabellaConfigurazione;
import it.poliba.is45.ecoshipping.dto.TabellaConfigurazioneDto;
import it.poliba.is45.ecoshipping.repository.TabellaConfigurazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TabellaConfigurazioneService {
    @Autowired
    TabellaConfigurazioneRepository tabellaConfigurazioneRepository;

    private TabellaConfigurazioneDto utilsForCreation (TabellaConfigurazione tabellaConfigurazione) {

        TabellaConfigurazioneDto tabellaConfigurazioneDto = new TabellaConfigurazioneDto();
        tabellaConfigurazioneDto.setConf_key(tabellaConfigurazione.getConfKey());
        tabellaConfigurazioneDto.setConf_value(tabellaConfigurazione.getConfValue());
        return tabellaConfigurazioneDto;

    }

}