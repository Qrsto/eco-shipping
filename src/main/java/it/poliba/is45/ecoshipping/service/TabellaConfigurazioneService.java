package it.poliba.is45.ecoshipping.service;

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

    private TabellaConfigurazioneDto toTabellaConfigurazioneDto(TabellaConfigurazione tabellaConfigurazione){
        TabellaConfigurazioneDto tabellaConfigurazioneDto = new TabellaConfigurazioneDto();
        tabellaConfigurazioneDto.setConf_key(tabellaConfigurazione.getConf_key());
        tabellaConfigurazioneDto.setConf_value(tabellaConfigurazione.getConf_value());
        return tabellaConfigurazioneDto;
    }
}

