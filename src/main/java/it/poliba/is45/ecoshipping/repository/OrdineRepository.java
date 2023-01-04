package it.poliba.is45.ecoshipping.repository;

import it.poliba.is45.ecoshipping.domain.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Integer> {
    @Transactional
    @Modifying
    @Query("update Ordine o set o.costoFinale = ?1")
    float updateCostoFinaleBy(float costoFinale);





}
