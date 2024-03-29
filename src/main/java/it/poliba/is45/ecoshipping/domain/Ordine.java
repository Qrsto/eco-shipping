package it.poliba.is45.ecoshipping.domain;

import it.poliba.is45.ecoshipping.enumeratives.FasciaOraria;
import it.poliba.is45.ecoshipping.enumeratives.MetodoPagamento;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.persistence.*;
import java.util.Set;

@Getter               //METODI (LOMBOCK)
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
public class Ordine{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ordine")
	private int idOrdine;                         //PK
	@Column(name = "FK_id_spedizione")
	private int idSpedizione;
	@Column(name = "indirizzo_partenza")
	private String indirizzoPartenza;
	@Column(name = "indirizzo_consegna")
	private String indirizzoConsegna;
	@Column(name = "volume_spedizione")
	private float volumeSpedizione;
	@Column(name = "peso_spedizione")
	private float pesoSpedizione;
	@Column(name = "num_telefono_destinatario")
	private String numTelefonoDestinatario;
	@Enumerated(EnumType.STRING)
	@Column(name = "metodo_pagamento")
	private MetodoPagamento metodoPagamento;
	@Column(name = "note_consegna")
	private String noteConsegna;
	@Enumerated (EnumType.STRING)
	@Column(name = "fascia_oraria")
	private FasciaOraria fasciaOraria;
	@Column(name = "costo_finale")
	private float costoFinale;
	@Column(name = "longitudine_partenza")
	private Double longitudinePartenza;
	@Column(name = "latitudine_partenza")
	private Double latitudinePartenza;
	@Column(name = "longitudine_destinazione")
	private Double longitudineDestinazione;
	@Column(name = "latitudine_destinazione")
	private Double latitudineDestinazione;

	/*
	@Column(name = "id_utente")
	private int idUtente;
*/
	//relazione bidirezionale N:1 (inversa)


	/* relazione 1:1 con spedizione
	con @OneToOne(mappedBy = "ordine", cascade = CascadeType.ALL, orphanRemoval = true) stiamo indicando a JPA
	che c'è una relazione 1:1 con la classe Ordine che mappa la tabella Spedizione. Inoltre, con cascade = CascadeType.ALL,
	indichiamo che è attivo il cascade su tutte le operazioni di  INSERT, UPDATE, DELETE (non è obbligatorio avere il cascade lato db).
	Infine, con orphanRemoval = true indichiamo che se un figlio, Spedizione, rimane "orfano" del padre, Ordine,
	(ovvero ha foreign key null), deve essere cancellato automaticamente.
	*/
	@OneToOne(fetch = FetchType.LAZY,
			cascade =  CascadeType.ALL,
			mappedBy = "ordine")
	private Spedizione spedizione;


	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;







}
