package it.poliba.is45.ecoshipping.repository;

import it.poliba.is45.ecoshipping.domain.utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//applicarlo a tutte le entity
@Repository
public interface UtenteRepository extends JpaRepository<utente,Long> {

}
