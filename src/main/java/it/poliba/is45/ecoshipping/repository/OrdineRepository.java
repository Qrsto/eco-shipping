package it.poliba.is45.ecoshipping.repository;

import it.poliba.is45.ecoshipping.domain.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Integer> {



}
