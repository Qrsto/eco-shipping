package it.poliba.is45.ecoshipping.repository;

import it.poliba.is45.ecoshipping.domain.Spedizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpedizioneRepository extends JpaRepository<Spedizione, Integer> {
}
