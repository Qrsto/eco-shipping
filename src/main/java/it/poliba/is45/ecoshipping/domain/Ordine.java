package it.poliba.is45.ecoshipping.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.persistence.*;

@Getter               //METODI (GRAZIE A LOMBOCK)
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ordine")
	private int idOrdine;
	@Column(name = "indirizzo_partenza")
	private String indirizzoPartenza;
	@Column(name = "indirizzo_consegna")
	private String indirizzoConsegna;
	@Column(name = "volume_spedizione")
	private float volumeSpedizione;
	@Column(name = "num_telefono_destinatario")
	private int numTelefonoDestinatario;
	@Column(name = "metodo_pagamento")
	private String metodoPagamento;
	@Column(name = "note_consegna")
	private String noteConsegna;
	@Column(name = "fascia_oraria")
	private String fasciaOraria;
	@Column(name = "costo_finale")
	private float costoFinale;
	@Column(name = "longitudine_partenza")
	private double longitudinePartenza;
	@Column(name = "latitudine_partenza")
	private double latitudinePartenza;
	@Column(name = "longitudine_destinazione")
	private double longitudineDestinazione;
	@Column(name = "latitudine_destinazione")
	private double latitudineDestinazione;
	@Column(name = "id_utente")
	private int idUtente;


}
