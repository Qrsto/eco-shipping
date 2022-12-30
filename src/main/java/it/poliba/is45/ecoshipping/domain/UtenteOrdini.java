package it.poliba.is45.ecoshipping.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "utente_ordini")
public class UtenteOrdini {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_utente_ordini")
    private int idUtenteOrdini;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "id_ordine")
    private Ordine ordine;


}
