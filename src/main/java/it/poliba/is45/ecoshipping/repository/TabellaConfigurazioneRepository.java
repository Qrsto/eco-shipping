package it.poliba.is45.ecoshipping.repository;

import it.poliba.is45.ecoshipping.domain.TabellaConfigurazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TabellaConfigurazioneRepository extends JpaRepository<TabellaConfigurazione, String> {
    public List<TabellaConfigurazione> getTabellaConfigurazione();

}
