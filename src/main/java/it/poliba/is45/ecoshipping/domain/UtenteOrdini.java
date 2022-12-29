package it.poliba.is45.ecoshipping.domain;

import javax.persistence.*;

@Entity
@Table(name = "utente_ordini")
public class UtenteOrdini {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "id_ordine")
    private Ordine ordine;


}
