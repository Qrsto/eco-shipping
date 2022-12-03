package it.poliba.is45.ecoshipping.repository;

import it.poliba.is45.ecoshipping.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//applicarlo a tutte le entity
@Repository
public interface UtenteRepository extends JpaRepository<Utente,Long> {

}
