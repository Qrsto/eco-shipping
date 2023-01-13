package it.poliba.is45.ecoshipping.repository;

import it.poliba.is45.ecoshipping.domain.Ordine;
import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.dto.OrdineDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Integer> {
    @Transactional
    @Modifying
    @Query("update Ordine o set o.costoFinale = ?1")
    float updateCostoFinaleBy(float costoFinale);

    Optional<Ordine> findById (int id);
    List<Ordine> findAll();




}
