package it.poliba.is45.ecoshipping.repository;

import it.poliba.is45.ecoshipping.Enum.TipoUtente;
import it.poliba.is45.ecoshipping.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//applicarlo a tutte le entity
@Repository
public interface UtenteRepository extends JpaRepository<Utente,Long> {

    public List<Utente> findAllByTipoUtente(TipoUtente tipoUtente);

}
