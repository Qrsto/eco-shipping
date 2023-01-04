package it.poliba.is45.ecoshipping.repository;


import it.poliba.is45.ecoshipping.dto.ClienteOrdineDto;
import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
import it.poliba.is45.ecoshipping.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;




@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {

    List<Utente> findAllByTipoUtente(TipoUtente tipoUtente);
/*
    @Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.ClienteOrdineDto(u.nomeCliente, u.cognomeCliente, u.idCliente, o.idOrdine)  "
            + "FROM Utente u INNER JOIN u.ordines o")
    List<ClienteOrdineDto> fetchUtenteOrdinidataInnerJoin();

 */




}
