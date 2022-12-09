package it.poliba.is45.ecoshipping.repository;

import it.poliba.is45.ecoshipping.dto.UtenteDto;
import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
import it.poliba.is45.ecoshipping.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//applicarlo a tutte le entity
@Repository
public interface UtenteRepository extends JpaRepository<Utente,Long> {

    public List<Utente> findAllByTipoUtente(TipoUtente tipoUtente);
    public Optional<Utente> findUtenteById (long id);




}
