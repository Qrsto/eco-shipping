package it.poliba.is45.ecoshipping.repository;


import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
import it.poliba.is45.ecoshipping.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;




@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {

    List<Utente> findAllByTipoUtente(TipoUtente tipoUtente);






}
